package com.poo.ifsp.poo_hotel_project.dtos.guests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDateTime;
import java.util.UUID;

public record UpdateGuestDto(
  String full_name,

  String document,

  @Email()
  String email,

  String phone,

  String address,

  @Past()
  LocalDateTime birth_date,

  boolean is_active
) {}