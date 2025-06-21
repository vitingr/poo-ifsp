package com.poo.ifsp.poo_hotel_project.usecases.reservations;

import com.poo.ifsp.poo_hotel_project.domain.entities.Guest;
import com.poo.ifsp.poo_hotel_project.domain.entities.HotelRoom;
import com.poo.ifsp.poo_hotel_project.domain.entities.Reservation;
import com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories.GuestRepository;
import com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories.HotelRoomRepository;
import com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories.ReservationRepository;
import com.poo.ifsp.poo_hotel_project.dtos.reservations.CreateReservationDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CreateReservationUseCase {

  private final ReservationRepository reservationRepository;
  private final GuestRepository guestRepository;
  private final HotelRoomRepository hotelRoomRepository;

  public CreateReservationUseCase(ReservationRepository reservationRepository,
                                  GuestRepository guestRepository,
                                  HotelRoomRepository hotelRoomRepository) {
    this.reservationRepository = reservationRepository;
    this.guestRepository = guestRepository;
    this.hotelRoomRepository = hotelRoomRepository;
  }

  @Transactional
  public Reservation execute(CreateReservationDto data) {
    validateDates(data.start_date(), data.end_date());

    Guest guest = guestRepository.findById(data.guest_id())
            .orElseThrow(() -> new RuntimeException("Guest not found with id: " + data.guest_id()));

    HotelRoom room = hotelRoomRepository.findById(data.room_id())
            .orElseThrow(() -> new RuntimeException("Room not found with id: " + data.room_id()));

    if (!room.isIs_available()) {
      throw new RuntimeException("Room is not available for booking.");
    }

    List<Reservation> conflictingReservations = reservationRepository
            .findConflictingReservations(room.getId(), data.start_date(), data.end_date());

    if (!conflictingReservations.isEmpty()) {
      throw new RuntimeException("Room is already booked for the selected dates.");
    }

    Reservation newReservation = new Reservation();
    newReservation.setGuest_id(guest.getId());
    newReservation.setRoom_id(room.getId());
    newReservation.setStart_date(data.start_date());
    newReservation.setEnd_date(data.end_date());
    newReservation.setTotal_price(data.total_price());

    room.setIs_available(false);
    hotelRoomRepository.save(room);
    return reservationRepository.save(newReservation);
  }

  private void validateDates(java.time.LocalDateTime start, java.time.LocalDateTime end) {
    if (!end.isAfter(start)) {
      throw new IllegalArgumentException("End date must be after start date.");
    }
  }
}
