package com.poo.ifsp.poo_hotel_project.dtos.hotelRooms;

import java.util.List;

public record GetHotelRoomsByFloorDto(
  int floor,

  List<GetHotelRoomDto> rooms
) {
}
