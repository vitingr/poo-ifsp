package com.poo.ifsp.poo_hotel_project.dtos.checkouts;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record UpdateCheckoutDto(
  @NotBlank
  UUID id,

  UUID guest_id,

  UUID room_id,

  @NotNull
  UUID reservation_id,

  LocalDateTime checkout_date,

  @DecimalMin(value = "0.0", inclusive = false)
  BigDecimal total_price
) {
}
