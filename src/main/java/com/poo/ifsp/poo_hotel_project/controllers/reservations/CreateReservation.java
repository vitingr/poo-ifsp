package com.poo.ifsp.poo_hotel_project.controllers.reservations;

import com.poo.ifsp.poo_hotel_project.domain.entities.Reservation;
import com.poo.ifsp.poo_hotel_project.dtos.reservations.CreateReservationDto;
import com.poo.ifsp.poo_hotel_project.usecases.reservations.CreateReservationUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservations")
public class CreateReservation {

  private final CreateReservationUseCase createReservationUseCase;

  public CreateReservation(CreateReservationUseCase createReservationUseCase) {
    this.createReservationUseCase = createReservationUseCase;
  }

  @PostMapping
  public ResponseEntity<Reservation> create(@RequestBody @Valid CreateReservationDto dto) {
    Reservation reservation = createReservationUseCase.execute(dto);
    return ResponseEntity.status(HttpStatus.CREATED).body(reservation);
  }
}
