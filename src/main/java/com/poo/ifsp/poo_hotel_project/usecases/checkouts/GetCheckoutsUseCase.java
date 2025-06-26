package com.poo.ifsp.poo_hotel_project.usecases.checkouts;

import com.poo.ifsp.poo_hotel_project.domain.entities.Checkout;
import com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories.CheckoutRepository;
import com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories.GuestRepository;
import com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories.HotelRoomRepository;
import com.poo.ifsp.poo_hotel_project.dtos.checkouts.GetCheckoutDto;
import com.poo.ifsp.poo_hotel_project.dtos.reservations.GetReservationDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GetCheckoutsUseCase {
  private final CheckoutRepository checkoutRepository;
  private final GuestRepository guestRepository;
  private final HotelRoomRepository hotelRoomRepository;

  public GetCheckoutsUseCase(
    CheckoutRepository checkoutRepository,
    GuestRepository guestRepository,
    HotelRoomRepository hotelRoomRepository
  ) {
    this.checkoutRepository = checkoutRepository;
    this.guestRepository = guestRepository;
    this.hotelRoomRepository = hotelRoomRepository;
  }

  public List<GetCheckoutDto> findAllWithGuest() {
    List<Checkout> checkouts = checkoutRepository.findAll();

    return checkouts.stream().map(checkout -> {
      var guest = guestRepository.findById(checkout.getGuest_id()).orElse(null);
      var room = hotelRoomRepository.findById(checkout.getRoom_id()).orElse(null);

      return new GetCheckoutDto(
        checkout.getId(),
        checkout.getGuest_id(),
        checkout.getRoom_id(),
        checkout.getReservation_id(),
        checkout.getCheckout_date(),
        checkout.getTotal_price(),
        guest != null ? guest.getFull_name() : "Alfredo",
        room != null ? room.getRoom_code() : "Z-0000"
      );
    }).toList();
  }

  public List<Checkout> findAll() {
    return checkoutRepository.findAll();
  }

  public Optional<Checkout> findById(UUID id) {
    return checkoutRepository.findById(id);
  }
}
