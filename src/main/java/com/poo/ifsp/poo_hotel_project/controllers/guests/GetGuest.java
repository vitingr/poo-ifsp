package com.poo.ifsp.poo_hotel_project.controllers.guests;

import com.poo.ifsp.poo_hotel_project.dtos.guests.GuestDto;
import com.poo.ifsp.poo_hotel_project.mappers.guest.GetGuestMapper;
import com.poo.ifsp.poo_hotel_project.usecases.guests.GetGuestUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/guests")
public class GetGuest {

  private final GetGuestUseCase useCase;
  private final GetGuestMapper mapper;

  public GetGuest(GetGuestUseCase useCase, GetGuestMapper mapper) {
    this.useCase = useCase;
    this.mapper = mapper;
  }

  @GetMapping
  public ResponseEntity<List<GuestDto>> getAll() {
    var guests = useCase.findAll();
    return ResponseEntity.ok(mapper.toDtoList(guests));
  }

  @GetMapping("/{id}")
  public ResponseEntity<GuestDto> getById(@PathVariable UUID id) {
    return useCase.findById(id)
      .map(guest -> ResponseEntity.ok(mapper.toDto(guest)))
      .orElse(ResponseEntity.notFound().build());
  }
}
