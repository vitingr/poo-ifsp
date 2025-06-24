package com.poo.ifsp.poo_hotel_project.usecases.reservations;

import com.poo.ifsp.poo_hotel_project.domain.entities.Reservation;
import com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories.ReservationRepository;
import com.poo.ifsp.poo_hotel_project.dtos.reservations.UpdateReservationDto;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UpdateReservationUseCase {
  private final ReservationRepository reservationRepository;

  public UpdateReservationUseCase(ReservationRepository reservationRepository) {
    this.reservationRepository = reservationRepository;
  }

  @Transactional
  public Optional<Reservation> execute(UUID id, UpdateReservationDto dto) {
    return reservationRepository.findById(id).map(reservation -> {
      reservation.updateFromDto(dto);
      return reservationRepository.save(reservation);
    });
  }
}
