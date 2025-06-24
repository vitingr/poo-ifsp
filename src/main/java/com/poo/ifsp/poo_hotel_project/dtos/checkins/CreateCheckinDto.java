package com.poo.ifsp.poo_hotel_project.dtos.checkins;

import jakarta.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.UUID;
import java.math.BigDecimal;

public record CreateCheckinDto(
  @NotNull()
  UUID guest_id,

  @NotNull
  UUID reservation_id,

  @NotNull()
  UUID room_id,

  @NotNull()
  @PastOrPresent()
  LocalDateTime checkin_date,

  @NotNull()
  @Future()
  LocalDateTime checkout_estimated
) {
}
