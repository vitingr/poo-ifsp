package com.poo.ifsp.poo_hotel_project.usecases.reservations;

import com.poo.ifsp.poo_hotel_project.domain.entities.Reservation;
import com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories.ReservationRepository;
import com.poo.ifsp.poo_hotel_project.dtos.reservations.CreateReservationDto;
import com.poo.ifsp.poo_hotel_project.mappers.reservations.CreateReservationMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CreateReservationUseCase {
  private final CreateReservationMapper reservationMapper;
  private final ReservationRepository reservationRepository;

  public CreateReservationUseCase(CreateReservationMapper reservationMapper, ReservationRepository reservationRepository) {
    this.reservationMapper = reservationMapper;
    this.reservationRepository = reservationRepository;
  }

  @Transactional
  public Reservation execute(CreateReservationDto dto) {
    Reservation reservation = reservationMapper.toEntity(dto);
    return reservationRepository.save(reservation);
  }
}
