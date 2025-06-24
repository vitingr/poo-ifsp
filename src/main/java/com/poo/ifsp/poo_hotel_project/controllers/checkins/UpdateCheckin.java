package com.poo.ifsp.poo_hotel_project.controllers.checkins;

import com.poo.ifsp.poo_hotel_project.dtos.checkins.UpdateCheckinDto;
import com.poo.ifsp.poo_hotel_project.usecases.checkins.UpdateCheckinUseCase;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/checkins")
public class UpdateCheckin {
  private final UpdateCheckinUseCase updateCheckinUseCase;

  public UpdateCheckin(UpdateCheckinUseCase updateCheckinUseCase) {
    this.updateCheckinUseCase = updateCheckinUseCase;
  }

  @PatchMapping("/{id}")
  public ResponseEntity<Void> update(@PathVariable UUID id, @RequestBody @Valid UpdateCheckinDto dto) {
    var result = updateCheckinUseCase.execute(id, dto);
    return result.isPresent()
      ? ResponseEntity.ok().build()
      : ResponseEntity.notFound().build();
  }
}
