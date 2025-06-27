package com.poo.ifsp.poo_hotel_project.controllers.auth.users;

import com.poo.ifsp.poo_hotel_project.dtos.auth.user.UpdateUserDto;
import com.poo.ifsp.poo_hotel_project.usecases.auth.users.UpdateUserUseCase;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UpdateUser {
  private final UpdateUserUseCase updateUserUseCase;

  public UpdateUser(UpdateUserUseCase updateUserUseCase) {
    this.updateUserUseCase = updateUserUseCase;
  }

  @PatchMapping("/{id}")
  public ResponseEntity<Void> update(@PathVariable UUID id, @RequestBody @Valid UpdateUserDto dto) {
    var result = updateUserUseCase.execute(id, dto);
    return result.isPresent()
      ? ResponseEntity.ok().build()
      : ResponseEntity.notFound().build();
  }
}
