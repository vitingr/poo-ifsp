package com.poo.ifsp.poo_hotel_project.mappers.guests;

import com.poo.ifsp.poo_hotel_project.domain.entities.Guest;
import com.poo.ifsp.poo_hotel_project.dtos.guests.CreateGuestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreateGuestMapper {
    Guest toEntity(CreateGuestDto dto);

    Guest toDto(Guest guest);
}
