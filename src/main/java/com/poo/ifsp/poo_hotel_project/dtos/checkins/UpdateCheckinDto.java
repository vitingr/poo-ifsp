package com.poo.ifsp.poo_hotel_project.dtos.checkins;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDateTime;
import java.util.UUID;

public record UpdateCheckinDto(
  @NotBlank
  UUID id,

  UUID guest_id,

  UUID room_id,

  UUID reservation_id,

  @PastOrPresent
  LocalDateTime checkin_date,

  @Future
  LocalDateTime checkout_estimated
) {
}
