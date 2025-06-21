package com.poo.ifsp.poo_hotel_project.dtos.guests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;
import java.util.UUID;

public record GuestDto(
  @NotBlank()
  UUID id,

  @NotBlank()
  String full_name,

  @NotBlank()
  String document,

  @NotBlank()
  @Email()
  String email,

  @NotBlank()
  String phone,

  @NotBlank()
  String address,

  @NotBlank()
  @Past()
  LocalDate birth_date
) {}
