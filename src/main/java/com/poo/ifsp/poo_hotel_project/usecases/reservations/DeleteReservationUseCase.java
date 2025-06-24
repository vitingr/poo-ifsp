package com.poo.ifsp.poo_hotel_project.usecases.reservations;

import com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories.ReservationRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteReservationUseCase {
  private final ReservationRepository reservationRepository;

  public DeleteReservationUseCase(ReservationRepository reservationRepository) {
    this.reservationRepository = reservationRepository;
  }

  @Transactional
  public boolean execute(UUID id) {
    if (!reservationRepository.existsById(id)) return false;
    reservationRepository.deleteById(id);
    return true;
  }
}
