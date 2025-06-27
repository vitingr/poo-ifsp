package com.poo.ifsp.poo_hotel_project.dtos.auth.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record UpdateUserDto(
  @Email
  String email,

  @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres")
  String password
) {
}
