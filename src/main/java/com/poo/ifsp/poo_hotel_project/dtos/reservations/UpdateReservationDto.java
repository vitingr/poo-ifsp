package com.poo.ifsp.poo_hotel_project.dtos.reservations;

import com.poo.ifsp.poo_hotel_project.domain.enums.ReservationStatus;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record UpdateReservationDto(
  @NotNull()
  UUID id,

  UUID guest_id,

  UUID room_id,

  @FutureOrPresent
  LocalDateTime start_date,

  @Future
  LocalDateTime end_date,

  ReservationStatus status,

  @Digits(integer = 10, fraction = 2)
  @PositiveOrZero
  BigDecimal total_price
) {
}
