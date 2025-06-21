package com.poo.ifsp.poo_hotel_project.dtos.hotelRooms;

import com.poo.ifsp.poo_hotel_project.domain.enums.RoomType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record GetHotelRoomDto(
  UUID id,
  String room_code,
  int floor,
  RoomType room_type,
  int beds_qtd,
  int max_capacity,
  BigDecimal price_per_night,
  boolean is_available,
  String description,
  String room_image,
  boolean has_wifi,
  boolean has_tv,
  LocalDateTime created_at,
  LocalDateTime updated_at
) {
}
