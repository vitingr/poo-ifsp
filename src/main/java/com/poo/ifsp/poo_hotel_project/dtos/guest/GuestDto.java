package com.poo.ifsp.poo_hotel_project.dtos.guest;

import java.time.LocalDate;
import java.util.UUID;

public record GuestDto(
        UUID id,
        String full_name,
        String document,
        String email,
        String phone,
        String address,
        LocalDate birth_date
) {}
