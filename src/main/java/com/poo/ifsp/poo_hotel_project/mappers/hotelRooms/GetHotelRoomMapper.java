package com.poo.ifsp.poo_hotel_project.mappers.hotelRooms;

import com.poo.ifsp.poo_hotel_project.domain.entities.HotelRoom;
import com.poo.ifsp.poo_hotel_project.dtos.hotelRooms.GetHotelRoomDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GetHotelRoomMapper {
  GetHotelRoomDto toDto(HotelRoom hotelRoom);
  List<GetHotelRoomDto> toDtoList(List<HotelRoom> hotelRooms);
}
