package com.poo.ifsp.poo_hotel_project.dtos.guest;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UpdateGuestDto(
        @NotBlank
        String phone,

        @Email
        String email,

        @NotBlank
        String address
) {}