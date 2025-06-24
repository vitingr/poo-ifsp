package com.poo.ifsp.poo_hotel_project.controllers.reservations;

import com.poo.ifsp.poo_hotel_project.dtos.reservations.UpdateReservationDto;
import com.poo.ifsp.poo_hotel_project.usecases.reservations.UpdateReservationUseCase;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/reservations")
public class UpdateReservation {
  private final UpdateReservationUseCase updateReservationUseCase;

  public UpdateReservation(UpdateReservationUseCase updateReservationUseCase) {
    this.updateReservationUseCase = updateReservationUseCase;
  }

  @PatchMapping("/{id}")
  public ResponseEntity<Void> update(@PathVariable UUID id, @RequestBody @Valid UpdateReservationDto dto) {
    var result = updateReservationUseCase.execute(id, dto);
    return result.isPresent()
     ? ResponseEntity.ok().build()
     : ResponseEntity.notFound().build();
  }
}
