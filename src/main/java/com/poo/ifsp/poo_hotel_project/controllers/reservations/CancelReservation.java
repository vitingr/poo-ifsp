package com.poo.ifsp.poo_hotel_project.controllers.reservations;

import com.poo.ifsp.poo_hotel_project.usecases.reservations.CancelReservationUseCase;
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelReservation(@PathVariable UUID id) {
        boolean canceled = cancelReservationUseCase.cancel(id);
        if (!canceled) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }
}
