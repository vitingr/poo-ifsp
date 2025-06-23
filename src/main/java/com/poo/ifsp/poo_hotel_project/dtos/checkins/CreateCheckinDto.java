package com.poo.ifsp.poo_hotel_project.dtos.checkins;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public record CreateCheckinDto(
        @NotNull UUID reservation_id
) {}
