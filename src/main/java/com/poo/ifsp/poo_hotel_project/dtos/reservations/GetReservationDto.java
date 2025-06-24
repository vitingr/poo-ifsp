package com.poo.ifsp.poo_hotel_project.dtos.reservations;

import com.poo.ifsp.poo_hotel_project.domain.enums.ReservationStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record GetReservationDto(
  UUID id,

  UUID guest_id,

  UUID room_id,

  LocalDateTime start_date,

  LocalDateTime end_date,

  ReservationStatus status,

  BigDecimal total_price,

  LocalDateTime created_at,

  LocalDateTime updated_at
) {
}
