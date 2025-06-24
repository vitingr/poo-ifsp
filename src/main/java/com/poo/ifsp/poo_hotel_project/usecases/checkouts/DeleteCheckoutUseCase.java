package com.poo.ifsp.poo_hotel_project.usecases.checkouts;

import com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories.CheckoutRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteCheckoutUseCase {
  private final CheckoutRepository checkoutRepository;

  public DeleteCheckoutUseCase(CheckoutRepository checkoutRepository) {
    this.checkoutRepository = checkoutRepository;
  }

  @Transactional
  public boolean execute(UUID id) {
    if (!checkoutRepository.existsById(id)) return false;
    checkoutRepository.deleteById(id);
    return true;
  }
}
