package com.poo.ifsp.poo_hotel_project.dtos.hotelRoom;

import com.poo.ifsp.poo_hotel_project.domain.enums.RoomType;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public record CreateHotelRoomDto(
  @NotBlank
  String room_code,

  @Min(0)
  int floor,

  @NotNull
  RoomType room_type,

  @Min(1)
  int beds_qtd,

  @Min(1)
  int max_capacity,

  @NotNull
  @DecimalMin(value = "0.0", inclusive = false)
  BigDecimal price_per_night,

  @NotBlank
  String description,

  @NotBlank
  String room_image,

  boolean has_wifi,

  boolean has_tv
) {}
