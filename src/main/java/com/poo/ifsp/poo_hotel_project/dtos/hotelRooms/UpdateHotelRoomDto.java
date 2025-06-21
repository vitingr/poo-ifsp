package com.poo.ifsp.poo_hotel_project.dtos.hotelRooms;

import com.poo.ifsp.poo_hotel_project.domain.enums.RoomType;
import jakarta.validation.constraints.*;
import java.util.UUID;
import java.math.BigDecimal;

public record UpdateHotelRoomDto (
  @NotBlank()
  UUID id,

  @Size(min = 2, max = 20)
  String room_code,

  @Positive()
  Integer floor,

  RoomType room_type,

  @Positive()
  Integer beds_qtd,

  @Positive()
  Integer max_capacity,

  @Digits(integer = 10, fraction = 2)
  @Positive()
  BigDecimal price_per_night,

  Boolean is_available,

  @Size(max = 500)
  String description,

  String room_image,

  Boolean has_wifi,

  Boolean has_tv
) {}
