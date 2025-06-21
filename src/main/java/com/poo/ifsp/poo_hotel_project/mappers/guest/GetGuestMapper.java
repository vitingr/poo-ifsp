package com.poo.ifsp.poo_hotel_project.mappers.guest;

import com.poo.ifsp.poo_hotel_project.domain.entities.Guest;
import com.poo.ifsp.poo_hotel_project.dtos.guests.GuestDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GetGuestMapper {
    GuestDto toDto(Guest guest);
    List<GuestDto> toDtoList(List<Guest> guests);
}