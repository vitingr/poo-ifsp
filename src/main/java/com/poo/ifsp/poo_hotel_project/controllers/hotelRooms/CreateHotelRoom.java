package com.poo.ifsp.poo_hotel_project.controllers.hotelRooms;

import com.poo.ifsp.poo_hotel_project.domain.entities.HotelRoom;
import com.poo.ifsp.poo_hotel_project.dtos.hotelRooms.CreateHotelRoomDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.poo.ifsp.poo_hotel_project.usecases.hotelRooms.CreateHotelRoomUseCase;

@RestController
@RequestMapping("/hotel-rooms")
public class CreateHotelRoom {
  private final CreateHotelRoomUseCase createHotelRoomUseCase;

  public CreateHotelRoom(CreateHotelRoomUseCase createHotelRoomUseCase) {
    this.createHotelRoomUseCase = createHotelRoomUseCase;
  }

  @PostMapping
  public ResponseEntity<HotelRoom> createHotelRoom(@RequestBody @Valid CreateHotelRoomDto hotelRoomDto) {
    HotelRoom savedHotelRoom = createHotelRoomUseCase.execute(hotelRoomDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedHotelRoom);
  }
}
