package com.poo.ifsp.poo_hotel_project.controllers.checkouts;

import com.poo.ifsp.poo_hotel_project.usecases.checkouts.DeleteCheckoutUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/checkouts")
public class DeleteCheckout {
  private final DeleteCheckoutUseCase deleteCheckoutUseCase;

  public DeleteCheckout(DeleteCheckoutUseCase deleteCheckoutUseCase) {
    this.deleteCheckoutUseCase = deleteCheckoutUseCase;
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable UUID id) {
    boolean deleted = deleteCheckoutUseCase.execute(id);
    if (!deleted) return ResponseEntity.notFound().build();
    return ResponseEntity.notFound().build();
  }
}
