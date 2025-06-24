package com.poo.ifsp.poo_hotel_project.usecases.checkouts;

import com.poo.ifsp.poo_hotel_project.domain.entities.Checkout;
import com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories.CheckoutRepository;
import com.poo.ifsp.poo_hotel_project.dtos.checkouts.UpdateCheckoutDto;
import com.poo.ifsp.poo_hotel_project.usecases.hotelRooms.UpdateHotelRoomUseCase;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UpdateCheckoutUseCase {
  private final CheckoutRepository checkoutRepository;

  public UpdateCheckoutUseCase(CheckoutRepository checkoutRepository) {
    this.checkoutRepository = checkoutRepository;
  }

  @Transactional
  public Optional<Checkout> execute(UUID id, UpdateCheckoutDto dto) {
    return checkoutRepository.findById(id).map(checkout -> {
      checkout.updateFromDto(dto);
      return checkoutRepository.save(checkout);
    });
  }
}
