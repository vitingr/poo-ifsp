package com.poo.ifsp.poo_hotel_project.dtos.auth.account;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ValidateCredentialsDto(
  @NotBlank
  @Email
  String email,

  @NotBlank
  String password
) {
}
