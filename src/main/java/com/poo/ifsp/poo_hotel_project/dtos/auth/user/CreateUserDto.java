package com.poo.ifsp.poo_hotel_project.dtos.auth.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateUserDto(
  @NotBlank
  @Email
  String email
) {
}
