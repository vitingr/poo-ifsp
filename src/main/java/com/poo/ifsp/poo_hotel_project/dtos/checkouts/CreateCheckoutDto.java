package com.poo.ifsp.poo_hotel_project.dtos.checkouts;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record CreateCheckoutDto(
  @NotNull
  UUID guest_id,

  @NotNull
  UUID room_id,

  @NotNull
  LocalDateTime checkout_date,

  @NotNull
  LocalDateTime checkout_estimated,

  @NotNull
  @DecimalMin(value = "0.0", inclusive = false)
  BigDecimal total_price
) {
}
