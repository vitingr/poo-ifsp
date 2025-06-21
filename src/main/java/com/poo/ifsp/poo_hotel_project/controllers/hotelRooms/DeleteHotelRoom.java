package com.poo.ifsp.poo_hotel_project.controllers.hotelRooms;

import com.poo.ifsp.poo_hotel_project.usecases.hotelRooms.DeleteHotelRoomUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/hotel-rooms")
public class DeleteHotelRoom {
  private final DeleteHotelRoomUseCase deleteHotelRoomUseCase;

  public DeleteHotelRoom(DeleteHotelRoomUseCase deleteHotelRoomUseCase) {
    this.deleteHotelRoomUseCase = deleteHotelRoomUseCase;
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable UUID id) {
    boolean deleted = deleteHotelRoomUseCase.execute(id);
    if (!deleted) return ResponseEntity.notFound().build();
    return ResponseEntity.noContent().build();
  }
}
