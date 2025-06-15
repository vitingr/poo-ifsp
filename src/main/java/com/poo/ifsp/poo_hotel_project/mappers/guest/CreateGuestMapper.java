package com.poo.ifsp.poo_hotel_project.mappers.guest;

import com.poo.ifsp.poo_hotel_project.domain.models.Guest;
import com.poo.ifsp.poo_hotel_project.dtos.guest.CreateGuestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreateGuestMapper {
    Guest toEntity(CreateGuestDto dto);

    Guest toDto(Guest guest);
}
