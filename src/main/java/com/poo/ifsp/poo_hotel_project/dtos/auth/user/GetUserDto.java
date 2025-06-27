package com.poo.ifsp.poo_hotel_project.dtos.auth.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record GetUserDto(
  @NotNull
  UUID id,

  @NotNull
  @Email
  String email,

  @NotNull
  LocalDateTime created_at,

  LocalDateTime updated_at
) {
}
