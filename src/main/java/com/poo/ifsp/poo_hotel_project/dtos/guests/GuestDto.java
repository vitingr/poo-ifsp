package com.poo.ifsp.poo_hotel_project.dtos.guests;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record GuestDto(
  UUID id,
  String full_name,
  String document,
  String email,
  String phone,
  String address,
  LocalDate birth_date,
  boolean is_active,
  LocalDateTime created_at,
  LocalDateTime updated_at
) {}

