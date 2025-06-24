package com.poo.ifsp.poo_hotel_project.controllers.checkouts;

import com.poo.ifsp.poo_hotel_project.dtos.checkouts.GetCheckoutDto;
import com.poo.ifsp.poo_hotel_project.mappers.checkouts.GetCheckoutMapper;
import com.poo.ifsp.poo_hotel_project.usecases.checkouts.GetCheckoutsUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/checkouts")
public class GetCheckouts {
  private final GetCheckoutsUseCase getCheckoutsUseCase;

  private final GetCheckoutMapper getCheckoutMapper;

  public GetCheckouts(GetCheckoutsUseCase getCheckoutsUseCase, GetCheckoutMapper getCheckoutMapper) {
    this.getCheckoutMapper = getCheckoutMapper;
    this.getCheckoutsUseCase = getCheckoutsUseCase;
  }

  @GetMapping
  public ResponseEntity<List<GetCheckoutDto>> getAll() {
    var checkouts = getCheckoutsUseCase.findAll();
    return ResponseEntity.ok(getCheckoutMapper.toDtoList(checkouts));
  }

  @GetMapping("/{id}")
  public ResponseEntity<GetCheckoutDto> getById(@PathVariable UUID id) {
    return getCheckoutsUseCase.findById(id)
      .map(checkout -> ResponseEntity.ok(getCheckoutMapper.toDto(checkout)))
      .orElse(ResponseEntity.notFound().build());
  }
}
