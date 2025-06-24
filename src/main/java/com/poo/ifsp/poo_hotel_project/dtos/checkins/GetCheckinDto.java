package com.poo.ifsp.poo_hotel_project.dtos.checkins;

import java.time.LocalDateTime;
import java.util.UUID;

public record GetCheckinDto(
   UUID id,

   UUID guest_id,

   UUID room_id,

   LocalDateTime checkin_date,

   LocalDateTime checkout_estimated,

   boolean is_active,

   LocalDateTime created_at,

   LocalDateTime updated_at
) {
}
