package com.poo.ifsp.poo_hotel_project.controllers.checkins;

import com.poo.ifsp.poo_hotel_project.domain.entities.Checkin;
import com.poo.ifsp.poo_hotel_project.dtos.checkins.CreateCheckinDto;
import com.poo.ifsp.poo_hotel_project.usecases.checkins.CreateCheckinUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/checkins")
public class CreateCheckin {

  private final CreateCheckinUseCase createCheckinUseCase;

  public CreateCheckin(CreateCheckinUseCase createCheckinUseCase) {
    this.createCheckinUseCase = createCheckinUseCase;
  }

  @PostMapping
  public ResponseEntity<Checkin> createCheckin(@RequestBody @Valid CreateCheckinDto dto) {
    Checkin checkin = createCheckinUseCase.execute(dto.reservation_id());
    return ResponseEntity.status(HttpStatus.CREATED).body(checkin);
  }
}
