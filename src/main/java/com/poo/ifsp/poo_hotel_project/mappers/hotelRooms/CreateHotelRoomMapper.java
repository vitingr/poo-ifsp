package com.poo.ifsp.poo_hotel_project.mappers.hotelRooms;

import com.poo.ifsp.poo_hotel_project.domain.entities.HotelRoom;
import com.poo.ifsp.poo_hotel_project.dtos.hotelRooms.CreateHotelRoomDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CreateHotelRoomMapper {
  @Mapping(target = "room_code", ignore = true)
  HotelRoom toEntity(CreateHotelRoomDto dto);

  HotelRoom toDto(HotelRoom hotelRoom);
}
