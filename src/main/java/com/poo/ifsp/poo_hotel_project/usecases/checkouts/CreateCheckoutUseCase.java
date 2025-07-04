package com.poo.ifsp.poo_hotel_project.usecases.checkouts;

import com.poo.ifsp.poo_hotel_project.domain.entities.Checkout;
import com.poo.ifsp.poo_hotel_project.domain.entities.Reservation;
import com.poo.ifsp.poo_hotel_project.domain.enums.ReservationStatus;
import com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories.CheckoutRepository;
import com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories.GuestRepository;
import com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories.HotelRoomRepository;
import com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories.ReservationRepository;
import com.poo.ifsp.poo_hotel_project.dtos.checkouts.CreateCheckoutDto;
import com.poo.ifsp.poo_hotel_project.mappers.checkouts.CreateCheckoutMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CreateCheckoutUseCase {
  private final CreateCheckoutMapper createCheckoutMapper;
  private final CheckoutRepository checkoutRepository;
  private final HotelRoomRepository hotelRoomRepository;
  private final ReservationRepository reservationRepository;
  private final GuestRepository guestRepository;

  public CreateCheckoutUseCase(
    CreateCheckoutMapper createCheckoutMapper,
    CheckoutRepository checkoutRepository,
    HotelRoomRepository hotelRoomRepository,
    ReservationRepository reservationRepository,
    GuestRepository guestRepository
  ) {
    this.checkoutRepository = checkoutRepository;
    this.createCheckoutMapper = createCheckoutMapper;
    this.hotelRoomRepository = hotelRoomRepository;
    this.reservationRepository = reservationRepository;
    this.guestRepository = guestRepository;
  }

  @Transactional
  public Checkout execute(CreateCheckoutDto dto) {
    Reservation reservation = reservationRepository.findById(dto.reservation_id())
      .orElseThrow(() -> new RuntimeException("Reservation not found"));

    if (reservation.getStatus() != ReservationStatus.ACTIVE) {
      throw new RuntimeException("You only can make a check-ou with status 'ACTIVE'.");
    }

    Checkout checkout = createCheckoutMapper.toEntity(dto);

    var hotelRoom = hotelRoomRepository.findById(dto.room_id())
      .orElseThrow(() -> new RuntimeException("Room not found"));

    var guest = reservation.getGuest();

    reservation.setStatus(ReservationStatus.FINISHED);
    hotelRoom.setIs_available(true);
    hotelRoomRepository.save(hotelRoom);

    checkout.setGuest(guest);
    checkout.setRoom(hotelRoom);

    return checkoutRepository.save(checkout);
  }
}
