package com.poo.ifsp.poo_hotel_project.controllers.guests;

import com.poo.ifsp.poo_hotel_project.domain.entities.Guest;
import com.poo.ifsp.poo_hotel_project.dtos.guests.CreateGuestDto;
import com.poo.ifsp.poo_hotel_project.usecases.guests.CreateGuestUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateGuest {
  private final CreateGuestUseCase createGuestUseCase;

  public CreateGuest(CreateGuestUseCase createGuestUseCase) {
    this.createGuestUseCase = createGuestUseCase;
  }

  @PostMapping("/guests")
  public ResponseEntity<Guest> createGuest(@RequestBody @Valid CreateGuestDto guestDto) {
    Guest savedGuest = createGuestUseCase.execute(guestDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedGuest);
  }
}
