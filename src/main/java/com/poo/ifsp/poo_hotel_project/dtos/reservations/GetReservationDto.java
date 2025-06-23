package com.poo.ifsp.poo_hotel_project.dtos.reservations;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record GetReservationDto(
        UUID id,
        UUID guest_id,
        UUID room_id,
        LocalDateTime start_date,
        LocalDateTime end_date,
        BigDecimal total_price,
        boolean isExpired
) {}
