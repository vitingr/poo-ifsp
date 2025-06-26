package com.poo.ifsp.poo_hotel_project.controllers.reservations;

import com.poo.ifsp.poo_hotel_project.domain.entities.Reservation;
import com.poo.ifsp.poo_hotel_project.dtos.reservations.GetReservationDto;
import com.poo.ifsp.poo_hotel_project.mappers.reservations.GetReservationMapper;
import com.poo.ifsp.poo_hotel_project.usecases.reservations.GetReservationsUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/reservations")
public class GetReservations {
  private final GetReservationsUseCase getReservationsUseCase;

  private final GetReservationMapper getReservationMapper;

  public GetReservations(GetReservationsUseCase getReservationsUseCase, GetReservationMapper getReservationMapper) {
    this.getReservationsUseCase = getReservationsUseCase;
    this.getReservationMapper = getReservationMapper;
  }

  @GetMapping
  public ResponseEntity<List<GetReservationDto>> getAll() {
    var reservations = getReservationsUseCase.findAllWithGuest();
    return ResponseEntity.ok(reservations);
  }

  @GetMapping("/{id}")
  public ResponseEntity<GetReservationDto> getById(@PathVariable UUID id) {
    return getReservationsUseCase.findById(id)
      .map(reservation -> ResponseEntity.ok(getReservationMapper.toDto(reservation)))
      .orElse(ResponseEntity.notFound().build());
  }
}
