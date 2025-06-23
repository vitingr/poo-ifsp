package com.poo.ifsp.poo_hotel_project.usecases.checkins;

import com.poo.ifsp.poo_hotel_project.domain.entities.Checkin;
import com.poo.ifsp.poo_hotel_project.domain.entities.Reservation;
import com.poo.ifsp.poo_hotel_project.domain.entities.HotelRoom;
import com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories.CheckinRepository;
import com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories.ReservationRepository;
import com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories.HotelRoomRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class CreateCheckinUseCase {

  private final ReservationRepository reservationRepository;
  private final HotelRoomRepository hotelRoomRepository;
  private final CheckinRepository checkinRepository;

  public CreateCheckinUseCase(
          ReservationRepository reservationRepository,
          HotelRoomRepository hotelRoomRepository,
          CheckinRepository checkinRepository
  ) {
    this.reservationRepository = reservationRepository;
    this.hotelRoomRepository = hotelRoomRepository;
    this.checkinRepository = checkinRepository;
  }

  @Transactional
  public Checkin execute(UUID reservationId) {
    Reservation reservation = reservationRepository.findById(reservationId)
            .orElseThrow(() -> new RuntimeException("Reservation not found with ID: " + reservationId));

    LocalDateTime now = LocalDateTime.now();
    if (now.isBefore(reservation.getStart_date()) || now.isAfter(reservation.getEnd_date())) {
      throw new RuntimeException("Check-in must be within reservation period.");
    }

    HotelRoom room = hotelRoomRepository.findById(reservation.getRoom_id())
            .orElseThrow(() -> new RuntimeException("Room not found for reservation."));

    Checkin checkin = new Checkin();
    checkin.setGuest_id(reservation.getGuest_id());
    checkin.setRoom_id(reservation.getRoom_id());
    checkin.setCheckin_date(now);
    checkin.setCheckout_estimated(reservation.getEnd_date());
    checkin.setTotal_price(reservation.getTotal_price());

    return checkinRepository.save(checkin);
  }
}
