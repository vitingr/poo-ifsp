package com.poo.ifsp.poo_hotel_project.controllers.checkins;

import com.poo.ifsp.poo_hotel_project.dtos.reservations.UpdateReservationDto;
import com.poo.ifsp.poo_hotel_project.usecases.reservations.CancelReservationUseCase;
import com.poo.ifsp.poo_hotel_project.usecases.reservations.UpdateReservationUseCase;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/reservations")
public class CancelReservation {
  private final CancelReservationUseCase cancelReservationUseCase;

  public CancelReservation(CancelReservationUseCase cancelReservationUseCase) {
    this.cancelReservationUseCase = cancelReservationUseCase;
  }

  @PatchMapping("/cancel-reservation/{id}")
  public ResponseEntity<Void> delete(@PathVariable UUID id) {
    boolean deleted = cancelReservationUseCase.execute(id);
    if (!deleted) return ResponseEntity.notFound().build();
    return ResponseEntity.ok().build();
  }
}
