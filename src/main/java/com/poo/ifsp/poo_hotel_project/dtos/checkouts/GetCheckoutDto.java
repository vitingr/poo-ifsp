package com.poo.ifsp.poo_hotel_project.dtos.checkouts;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record GetCheckoutDto(
  @NotNull
  UUID id,

  @NotNull
  UUID guest_id,

  @NotNull
  UUID room_id,

  @NotNull
  UUID reservation_id,

  @NotNull
  LocalDateTime checkout_date,

  @NotNull
  @DecimalMin(value = "0.0", inclusive = false)
  BigDecimal total_price,

  String guest_name,

  String room_code
) {
}
