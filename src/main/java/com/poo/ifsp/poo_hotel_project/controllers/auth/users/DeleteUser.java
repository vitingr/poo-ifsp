package com.poo.ifsp.poo_hotel_project.controllers.auth.users;

import com.poo.ifsp.poo_hotel_project.usecases.auth.users.DeleteUserUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class DeleteUser {
  private final DeleteUserUseCase deleteUserUseCase;

  public DeleteUser(DeleteUserUseCase deleteUserUseCase) {
    this.deleteUserUseCase = deleteUserUseCase;
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable UUID id) {
    boolean deleted = deleteUserUseCase.execute(id);
    if (!deleted) return ResponseEntity.notFound().build();
    return ResponseEntity.noContent().build();
  }
}
