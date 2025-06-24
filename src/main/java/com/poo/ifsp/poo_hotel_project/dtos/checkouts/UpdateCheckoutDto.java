package com.poo.ifsp.poo_hotel_project.dtos.checkouts;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record UpdateCheckoutDto(
  @NotNull
  UUID id,

  UUID guest_id,

  UUID room_id,

  LocalDateTime checkout_date,

  LocalDateTime checkout_estimated,

  @DecimalMin(value = "0.0", inclusive = false)
  BigDecimal total_price
) {
}
