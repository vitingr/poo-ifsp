package com.poo.ifsp.poo_hotel_project.controllers.auth.users;

import com.poo.ifsp.poo_hotel_project.domain.entities.User;
import com.poo.ifsp.poo_hotel_project.dtos.auth.user.CreateUserDto;
import com.poo.ifsp.poo_hotel_project.usecases.auth.users.CreateUserUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class CreateUser {
  private final CreateUserUseCase createUserUseCase;

  public CreateUser(CreateUserUseCase createUserUseCase) {
    this.createUserUseCase = createUserUseCase;
  }

  @PostMapping
  public ResponseEntity<User> createUser(@RequestBody @Valid CreateUserDto userDto) {
    User savedUser = createUserUseCase.execute(userDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
  }
}
