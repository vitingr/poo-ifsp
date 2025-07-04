package com.poo.ifsp.poo_hotel_project.dtos.reservations;

import jakarta.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.UUID;
import java.math.BigDecimal;

public record CreateReservationDto(
  @NotNull()
  UUID guest_id,

  @NotNull()
  UUID room_id,

  @NotNull()
  @FutureOrPresent()
  LocalDateTime start_date,

  @NotNull()
  @Future()
  LocalDateTime end_date
) {
}
