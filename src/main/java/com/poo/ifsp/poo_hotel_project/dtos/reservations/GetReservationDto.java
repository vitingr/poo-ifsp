package com.poo.ifsp.poo_hotel_project.dtos.reservations;

import com.poo.ifsp.poo_hotel_project.domain.enums.ReservationStatus;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record GetReservationDto(
  @NotNull
  UUID id,

  @NotNull
  UUID guest_id,

  @NotNull
  UUID room_id,

  @NotNull
  LocalDateTime start_date,

  @NotNull
  LocalDateTime end_date,

  @NotNull
  ReservationStatus status,

  @NotNull
  BigDecimal total_price,

  @NotNull
  LocalDateTime created_at,

  @NotNull
  LocalDateTime updated_at,

  String guest_name,

  String room_code
) {
}
