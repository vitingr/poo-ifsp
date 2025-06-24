package com.poo.ifsp.poo_hotel_project.controllers.checkins;

import com.poo.ifsp.poo_hotel_project.domain.entities.Checkin;
import com.poo.ifsp.poo_hotel_project.dtos.checkins.CreateCheckinDto;
import com.poo.ifsp.poo_hotel_project.usecases.checkins.CreateCheckinUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/checkins")
public class CreateCheckin {
  private final CreateCheckinUseCase createCheckinUseCase;

  public CreateCheckin(CreateCheckinUseCase createCheckinUseCase) {
    this.createCheckinUseCase = createCheckinUseCase;
  }

  @PostMapping
  public ResponseEntity<Checkin> createCheckin(@RequestBody @Valid CreateCheckinDto checkinDto) {
    Checkin savedCheckin = createCheckinUseCase.execute(checkinDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedCheckin);
  }
}
