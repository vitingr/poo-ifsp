package com.poo.ifsp.poo_hotel_project.dtos.checkins;

import jakarta.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.UUID;
import java.math.BigDecimal;

public record CreateCheckinDto(
  @NotNull()
  UUID guest_id,

  @NotNull()
  UUID room_id,

  @NotNull()
  @PastOrPresent()
  LocalDateTime checkin_date,

  @NotNull()
  @Future()
  LocalDateTime checkout_estimated,

  @NotNull()
  @DecimalMin(value = "0.00", inclusive = false)
  @Digits(integer = 10, fraction = 2)
  BigDecimal total_price
) {
}
