package com.poo.ifsp.poo_hotel_project.controllers.hotelRooms;

import com.poo.ifsp.poo_hotel_project.dtos.hotelRooms.UpdateHotelRoomDto;
import com.poo.ifsp.poo_hotel_project.usecases.hotelRooms.UpdateHotelRoomUseCase;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/hotel-rooms")
public class UpdateHotelRoom {
  private final UpdateHotelRoomUseCase updateHotelRoomUseCase;

  public UpdateHotelRoom(UpdateHotelRoomUseCase updateHotelRoomUseCase) {
    this.updateHotelRoomUseCase = updateHotelRoomUseCase;
  }

  @PatchMapping("/{id}")
  public ResponseEntity<Void> update(@PathVariable UUID id, @RequestBody @Valid UpdateHotelRoomDto dto) {
    var result = updateHotelRoomUseCase.execute(id, dto);
    return result.isPresent()
      ? ResponseEntity.ok().build()
      : ResponseEntity.notFound().build();
  }
}
