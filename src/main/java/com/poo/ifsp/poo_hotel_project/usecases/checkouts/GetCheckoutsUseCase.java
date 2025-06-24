package com.poo.ifsp.poo_hotel_project.usecases.checkouts;

import com.poo.ifsp.poo_hotel_project.domain.entities.Checkout;
import com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories.CheckoutRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GetCheckoutsUseCase {
  private final CheckoutRepository checkoutRepository;

  public GetCheckoutsUseCase(CheckoutRepository checkoutRepository) {
    this.checkoutRepository = checkoutRepository;
  }

  public List<Checkout> findAll() {
    return checkoutRepository.findAll();
  }

  public Optional<Checkout> findById(UUID id) {
    return checkoutRepository.findById(id);
  }
}
