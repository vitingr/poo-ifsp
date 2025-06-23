package com.poo.ifsp.poo_hotel_project.controllers.guests;

import com.poo.ifsp.poo_hotel_project.dtos.guests.UpdateGuestDto;
import com.poo.ifsp.poo_hotel_project.usecases.guests.UpdateGuestUseCase;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/guests")
public class UpdateGuest {
  private final UpdateGuestUseCase useCase;

  public UpdateGuest(UpdateGuestUseCase useCase) {
    this.useCase = useCase;
  }

  @PatchMapping("/{id}")
  public ResponseEntity<Void> update(@PathVariable UUID id, @RequestBody @Valid UpdateGuestDto dto) {
    var result = useCase.execute(id, dto);
    return result.isPresent()
            ? ResponseEntity.ok().build()
            : ResponseEntity.notFound().build();
  }
}
