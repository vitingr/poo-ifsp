package com.poo.ifsp.poo_hotel_project.mappers.hotelRoom;

import com.poo.ifsp.poo_hotel_project.domain.models.HotelRoom;
import com.poo.ifsp.poo_hotel_project.dtos.hotelRoom.CreateHotelRoomDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreateHotelRoomMapper {
  HotelRoom toEntity(CreateHotelRoomDto dto);

  HotelRoom toDto(HotelRoom hotelRoom);
}
