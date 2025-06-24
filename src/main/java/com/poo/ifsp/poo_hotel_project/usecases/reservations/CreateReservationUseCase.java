package com.poo.ifsp.poo_hotel_project.usecases.reservations;

import com.poo.ifsp.poo_hotel_project.domain.entities.HotelRoom;
import com.poo.ifsp.poo_hotel_project.domain.entities.Reservation;
import com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories.HotelRoomRepository;
import com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories.ReservationRepository;
import com.poo.ifsp.poo_hotel_project.dtos.reservations.CreateReservationDto;
import com.poo.ifsp.poo_hotel_project.mappers.reservations.CreateReservationMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class CreateReservationUseCase {
  private final CreateReservationMapper reservationMapper;
  private final ReservationRepository reservationRepository;
  private final HotelRoomRepository hotelRoomRepository;

  public CreateReservationUseCase(CreateReservationMapper reservationMapper, ReservationRepository reservationRepository, HotelRoomRepository hotelRoomRepository) {
    this.reservationMapper = reservationMapper;
    this.reservationRepository = reservationRepository;
    this.hotelRoomRepository = hotelRoomRepository;
  }

  @Transactional
  public Reservation execute(CreateReservationDto dto) {
    HotelRoom room = hotelRoomRepository.findById(dto.room_id()).orElseThrow(() -> new RuntimeException("Quarto não encontrado"));

    LocalDateTime start = dto.start_date();
    LocalDateTime end = dto.end_date();

    long nights = Duration.between(start, end).toDays();
    if (nights <= 0) {
      throw new RuntimeException("End date must be after start date");
    }

    BigDecimal totalPrice = room.getPrice_per_night().multiply(BigDecimal.valueOf(nights));

    Reservation reservation = reservationMapper.toEntity(dto);

    reservation.setTotal_price(totalPrice);

    return reservationRepository.save(reservation);
  }
}
