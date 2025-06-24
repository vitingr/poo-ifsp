package com.poo.ifsp.poo_hotel_project.controllers.checkins;

import com.poo.ifsp.poo_hotel_project.usecases.checkins.DeleteCheckinUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/checkins")
public class DeleteCheckin {
  private final DeleteCheckinUseCase deleteCheckinUseCase;

  public DeleteCheckin(DeleteCheckinUseCase deleteCheckinUseCase) {
    this.deleteCheckinUseCase = deleteCheckinUseCase;
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable UUID id) {
    boolean deleted = deleteCheckinUseCase.execute(id);
    if (!deleted) return ResponseEntity.notFound().build();
    return ResponseEntity.noContent().build();
  }
}
