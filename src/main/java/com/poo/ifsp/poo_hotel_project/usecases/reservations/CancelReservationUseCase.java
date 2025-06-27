package com.poo.ifsp.poo_hotel_project.usecases.reservations;

import com.poo.ifsp.poo_hotel_project.domain.entities.Reservation;
import com.poo.ifsp.poo_hotel_project.domain.enums.ReservationStatus;
import com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories.ReservationRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CancelReservationUseCase {
  private final ReservationRepository reservationRepository;

  public CancelReservationUseCase(ReservationRepository reservationRepository) {
    this.reservationRepository = reservationRepository;
  }

  @Transactional
  public boolean execute(UUID id) {
    Optional<Reservation> optionalReservation = reservationRepository.findById(id);
    if (optionalReservation.isEmpty()) return false;

    Reservation reservation = optionalReservation.get();
    reservation.setStatus(ReservationStatus.CANCELED);
    reservationRepository.save(reservation);

    return true;
  }
}
