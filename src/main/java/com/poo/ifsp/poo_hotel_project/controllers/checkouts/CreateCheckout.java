package com.poo.ifsp.poo_hotel_project.controllers.checkouts;

import com.poo.ifsp.poo_hotel_project.domain.entities.Checkout;
import com.poo.ifsp.poo_hotel_project.dtos.checkouts.CreateCheckoutDto;
import com.poo.ifsp.poo_hotel_project.usecases.checkouts.CreateCheckoutUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/checkouts")
public class CreateCheckout {
  private final CreateCheckoutUseCase createCheckoutUseCase;

  public CreateCheckout(CreateCheckoutUseCase createCheckoutUseCase) {
    this.createCheckoutUseCase = createCheckoutUseCase;
  }

  @PostMapping
  public ResponseEntity<Checkout> createCheckout(@RequestBody @Valid CreateCheckoutDto createCheckoutDto) {
    Checkout savedCheckout = createCheckoutUseCase.execute(createCheckoutDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedCheckout);
  }
}
