package com.poo.ifsp.poo_hotel_project.usecases.checkouts;

import com.poo.ifsp.poo_hotel_project.domain.entities.Checkout;
import com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories.CheckoutRepository;
import com.poo.ifsp.poo_hotel_project.dtos.checkouts.CreateCheckoutDto;
import com.poo.ifsp.poo_hotel_project.mappers.checkouts.CreateCheckoutMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CreateCheckoutUseCase {
  private final CreateCheckoutMapper createCheckoutMapper;

  private final CheckoutRepository checkoutRepository;

  public CreateCheckoutUseCase(CreateCheckoutMapper createCheckoutMapper, CheckoutRepository checkoutRepository) {
    this.checkoutRepository = checkoutRepository;
    this.createCheckoutMapper = createCheckoutMapper;
  }

  @Transactional
  public Checkout execute(CreateCheckoutDto dto) {
    Checkout checkout = createCheckoutMapper.toEntity(dto);
    return checkoutRepository.save(checkout);
  }
}
