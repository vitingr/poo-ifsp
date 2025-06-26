package com.poo.ifsp.poo_hotel_project.controllers.auth.account;

import com.poo.ifsp.poo_hotel_project.domain.entities.User;
import com.poo.ifsp.poo_hotel_project.dtos.auth.account.ValidateCredentialsDto;
import com.poo.ifsp.poo_hotel_project.usecases.auth.account.ValidateCredentialsUseCase;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidateCredentials {
  private final ValidateCredentialsUseCase validateCredentialsUseCase;

  public ValidateCredentials(ValidateCredentialsUseCase validateCredentialsUseCase) {
    this.validateCredentialsUseCase = validateCredentialsUseCase;
  }

  @PostMapping("/validate-code")
  public ResponseEntity<?> validateCredentials(@RequestBody @Valid ValidateCredentialsDto dto) {
    try {
      User user = validateCredentialsUseCase.execute(dto);
      return ResponseEntity.ok(user);
    } catch (IllegalArgumentException e) {
      return ResponseEntity.status(401).body(e.getMessage());
    }
  }
}
