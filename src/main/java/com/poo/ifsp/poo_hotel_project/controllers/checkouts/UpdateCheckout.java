package com.poo.ifsp.poo_hotel_project.controllers.checkouts;

import com.poo.ifsp.poo_hotel_project.dtos.checkouts.UpdateCheckoutDto;
import com.poo.ifsp.poo_hotel_project.usecases.checkouts.UpdateCheckoutUseCase;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/checkouts")
public class UpdateCheckout {
  private final UpdateCheckoutUseCase updateCheckoutUseCase;

  public UpdateCheckout(UpdateCheckoutUseCase updateCheckoutUseCase) {
    this.updateCheckoutUseCase = updateCheckoutUseCase;
  }

  @PatchMapping("/{id}")
  public ResponseEntity<Void> update(@PathVariable UUID id, @RequestBody @Valid UpdateCheckoutDto dto) {
    var result = updateCheckoutUseCase.execute(id, dto);
    return result.isPresent()
      ? ResponseEntity.ok().build()
      : ResponseEntity.notFound().build();
  }
}
