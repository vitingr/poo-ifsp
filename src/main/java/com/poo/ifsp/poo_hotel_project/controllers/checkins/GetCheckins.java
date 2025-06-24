package com.poo.ifsp.poo_hotel_project.controllers.checkins;

import com.poo.ifsp.poo_hotel_project.dtos.checkins.GetCheckinDto;
import com.poo.ifsp.poo_hotel_project.mappers.checkins.GetCheckinMapper;
import com.poo.ifsp.poo_hotel_project.usecases.checkins.GetCheckinsUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/checkins")
public class GetCheckins {
  private final GetCheckinsUseCase getCheckinsUseCase;
  private final GetCheckinMapper getCheckinMapper;

  public GetCheckins(GetCheckinsUseCase getCheckinsUseCase, GetCheckinMapper getCheckinMapper) {
    this.getCheckinMapper = getCheckinMapper;
    this.getCheckinsUseCase = getCheckinsUseCase;
  }

  @GetMapping
  public ResponseEntity<List<GetCheckinDto>> getAll() {
    var checkins = getCheckinsUseCase.findAll();
    return ResponseEntity.ok(getCheckinMapper.toDtoList(checkins));
  }

  @GetMapping("/{id}")
  public ResponseEntity<GetCheckinDto> getById(@PathVariable UUID id) {
    return getCheckinsUseCase.findById(id)
      .map(checkin -> ResponseEntity.ok(getCheckinMapper.toDto(checkin)))
      .orElse(ResponseEntity.notFound().build());
  }
}
