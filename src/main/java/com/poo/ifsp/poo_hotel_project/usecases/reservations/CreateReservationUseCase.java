package com.poo.ifsp.poo_hotel_project.usecases.reservations;

import com.poo.ifsp.poo_hotel_project.domain.entities.Guest;
import com.poo.ifsp.poo_hotel_project.domain.entities.HotelRoom;
import com.poo.ifsp.poo_hotel_project.domain.entities.Reservation;
import com.poo.ifsp.poo_hotel_project.domain.enums.ReservationStatus;
import com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories.GuestRepository;
import com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories.HotelRoomRepository;
import com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories.ReservationRepository;
import com.poo.ifsp.poo_hotel_project.dtos.reservations.CreateReservationDto;
import com.poo.ifsp.poo_hotel_project.mappers.reservations.CreateReservationMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CreateReservationUseCase {
  private final CreateReservationMapper reservationMapper;
  private final ReservationRepository reservationRepository;
  private final HotelRoomRepository hotelRoomRepository;
  private final GuestRepository guestRepository;

  public CreateReservationUseCase(
    CreateReservationMapper reservationMapper,
    ReservationRepository reservationRepository,
    HotelRoomRepository hotelRoomRepository,
    GuestRepository guestRepository
  ) {
    this.reservationMapper = reservationMapper;
    this.reservationRepository = reservationRepository;
    this.hotelRoomRepository = hotelRoomRepository;
    this.guestRepository = guestRepository;
  }

  @Transactional
  public Reservation execute(CreateReservationDto dto) {
    HotelRoom room = hotelRoomRepository.findById(dto.room_id()).orElseThrow(() -> new RuntimeException("Quarto não encontrado"));

    Guest guest = guestRepository.findById(dto.guest_id())
      .orElseThrow(() -> new RuntimeException("Guest not found."));

    LocalDateTime start = dto.start_date();
    LocalDateTime end = dto.end_date();

    long nights = Duration.between(start, end).toDays();
    if (nights <= 0) {
      throw new RuntimeException("End date must be after start date");
    }

    List<Reservation> conflictingReservations = reservationRepository.findConflictingReservations(
      dto.room_id(),
      dto.start_date(),
      dto.end_date()
    );

    if (!conflictingReservations.isEmpty()) {
      throw new RuntimeException("Already have a reservation booked for this period.");
    }

    BigDecimal totalPrice = room.getPrice_per_night().multiply(BigDecimal.valueOf(nights));

    Reservation reservation = reservationMapper.toEntity(dto);

    reservation.setRoom(room);
    reservation.setGuest(guest);
    reservation.setTotal_price(totalPrice);

    if (dto.start_date().toLocalDate().isEqual(LocalDateTime.now().toLocalDate())) {
      reservation.setStatus(ReservationStatus.ACTIVE);
    }

    return reservationRepository.save(reservation);
  }
}
