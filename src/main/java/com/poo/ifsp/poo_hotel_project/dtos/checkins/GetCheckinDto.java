package com.poo.ifsp.poo_hotel_project.dtos.checkins;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record GetCheckinDto(
        UUID id,
        UUID guest_id,
        UUID room_id,
        LocalDateTime checkin_date,
        LocalDateTime checkout_estimated,
        LocalDateTime checkout_date,
        BigDecimal total_price
) {}
