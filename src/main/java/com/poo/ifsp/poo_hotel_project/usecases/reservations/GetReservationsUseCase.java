package com.poo.ifsp.poo_hotel_project.usecases.reservations;

import com.poo.ifsp.poo_hotel_project.domain.entities.Reservation;
import com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories.GuestRepository;
import com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories.HotelRoomRepository;
import com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories.ReservationRepository;
import com.poo.ifsp.poo_hotel_project.dtos.reservations.GetReservationDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GetReservationsUseCase {
  private final ReservationRepository reservationRepository;
  private final GuestRepository guestRepository;
  private final HotelRoomRepository hotelRoomRepository;

  public GetReservationsUseCase(
    ReservationRepository reservationRepository,
    GuestRepository guestRepository,
    HotelRoomRepository hotelRoomRepository
  ) {
    this.reservationRepository = reservationRepository;
    this.guestRepository = guestRepository;
    this.hotelRoomRepository = hotelRoomRepository;
  }

  public List<GetReservationDto> findAllWithGuest() {
    List<Reservation> reservations = reservationRepository.findAll();

    return reservations.stream().map(reservation -> {
      var guest = guestRepository.findById(reservation.getGuest_id()).orElse(null);
      var room = hotelRoomRepository.findById(reservation.getRoom_id()).orElse(null);

      return new GetReservationDto(
        reservation.getId(),
        reservation.getGuest_id(),
        reservation.getRoom_id(),
        reservation.getStart_date(),
        reservation.getEnd_date(),
        reservation.getStatus(),
        reservation.getTotal_price(),
        reservation.getCreated_at(),
        reservation.getUpdated_at(),
        guest != null ? guest.getFull_name() : "Alfredo",
        room != null ? room.getRoom_code() : "Z-0000"
      );
    }).toList();
  }

  public List<Reservation> findAll() {
    return reservationRepository.findAll();
  }

  public Optional<Reservation> findById(UUID id) {
    return reservationRepository.findById(id);
  }
}
