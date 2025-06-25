package com.poo.ifsp.poo_hotel_project.usecases.checkins;

import com.poo.ifsp.poo_hotel_project.domain.entities.Reservation;
import com.poo.ifsp.poo_hotel_project.domain.enums.ReservationStatus;
import com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories.CheckinRepository;
import com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories.HotelRoomRepository;
import com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories.ReservationRepository;
import com.poo.ifsp.poo_hotel_project.dtos.checkins.CreateCheckinDto;
import com.poo.ifsp.poo_hotel_project.mappers.checkins.CreateCheckinMapper;
import com.poo.ifsp.poo_hotel_project.domain.entities.Checkin;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CreateCheckinUseCase {
  private final CreateCheckinMapper checkinMapper;
  private final CheckinRepository checkinRepository;
  private final HotelRoomRepository hotelRoomRepository;
  private final ReservationRepository reservationRepository;

  public CreateCheckinUseCase(
    CreateCheckinMapper checkinMapper,
    CheckinRepository checkinRepository,
    HotelRoomRepository hotelRoomRepository,
    ReservationRepository reservationRepository
  ) {
    this.checkinMapper = checkinMapper;
    this.checkinRepository = checkinRepository;
    this.hotelRoomRepository = hotelRoomRepository;
    this.reservationRepository = reservationRepository;
  }

  @Transactional
  public Checkin execute(CreateCheckinDto dto) {
    Reservation reservation = reservationRepository.findById(dto.reservation_id())
      .orElseThrow(() -> new RuntimeException("Reservation not found"));

    if (reservation.getStatus() != ReservationStatus.PENDING) {
      throw new RuntimeException("You only can make a check-in with status 'PENDING'.");
    }

    var hotelRoom = hotelRoomRepository.findById(dto.room_id())
      .orElseThrow(() -> new RuntimeException("Room not found"));

    reservation.setStatus(ReservationStatus.ACTIVE);
    hotelRoom.setIs_available(false);
    hotelRoomRepository.save(hotelRoom);

    Checkin checkin = checkinMapper.toEntity(dto);
    return checkinRepository.save(checkin);
  }
}
