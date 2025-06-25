package com.poo.ifsp.poo_hotel_project.dtos.checkins;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record GetCheckinDto(
  @NotNull
  UUID id,

  @NotNull
  UUID guest_id,

  @NotNull
  UUID reservation_id,

  @NotNull
  UUID room_id,

  @NotNull
  LocalDateTime checkin_date,
  @NotNull
  LocalDateTime checkout_estimated,

  String guest_name
) {
}
