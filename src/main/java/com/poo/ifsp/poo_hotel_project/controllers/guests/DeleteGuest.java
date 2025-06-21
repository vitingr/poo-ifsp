package com.poo.ifsp.poo_hotel_project.controllers.guests;

import com.poo.ifsp.poo_hotel_project.usecases.guests.DeleteGuestUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/guests")
public class DeleteGuest {
  private final DeleteGuestUseCase deleteGuestUseCase;

  public DeleteGuest(DeleteGuestUseCase deleteGuestUseCase) {
    this.deleteGuestUseCase = deleteGuestUseCase;
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable UUID id) {
    boolean deleted = deleteGuestUseCase.execute(id);
    if (!deleted) return ResponseEntity.notFound().build();
    return ResponseEntity.noContent().build();
  }
}
