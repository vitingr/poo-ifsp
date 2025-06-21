package com.poo.ifsp.poo_hotel_project.controllers.hotelRooms;

import com.poo.ifsp.poo_hotel_project.dtos.hotelRooms.GetHotelRoomDto;
import com.poo.ifsp.poo_hotel_project.mappers.hotelRooms.GetHotelRoomMapper;
import com.poo.ifsp.poo_hotel_project.usecases.hotelRooms.GetHotelRoomUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/hotel-rooms")
public class GetHotelRoom {
  private final GetHotelRoomUseCase getHotelRoomUseCase;

  private final GetHotelRoomMapper getHotelRoomMapper;

  public GetHotelRoom(GetHotelRoomUseCase getHotelRoomUseCase, GetHotelRoomMapper getHotelRoomMapper) {
    this.getHotelRoomMapper = getHotelRoomMapper;
    this.getHotelRoomUseCase = getHotelRoomUseCase;
  }

  @GetMapping
  public ResponseEntity<List<GetHotelRoomDto>> getAll() {
    var hotelRooms = getHotelRoomUseCase.findAll();
    return ResponseEntity.ok(getHotelRoomMapper.toDtoList(hotelRooms));
  }

  @GetMapping("/{id}")
  public ResponseEntity<GetHotelRoomDto> getById(@PathVariable UUID id) {
    return getHotelRoomUseCase.findById(id)
      .map(hotelRoom -> ResponseEntity.ok(getHotelRoomMapper.toDto(hotelRoom)))
      .orElse(ResponseEntity.notFound().build());
  }
}
