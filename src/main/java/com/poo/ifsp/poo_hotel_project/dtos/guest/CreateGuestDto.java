package com.poo.ifsp.poo_hotel_project.dtos.guest;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public record CreateGuestDto(
  @NotBlank()
  String full_name,

  @NotBlank()
  @Size(min = 5, max = 20)
  String document,

  @NotBlank()
  @Email()
  String email,

  @NotBlank()
  String phone,

  @NotBlank()
  String address,

  @NotNull()
  @Past()
  LocalDate birth_date
) {}