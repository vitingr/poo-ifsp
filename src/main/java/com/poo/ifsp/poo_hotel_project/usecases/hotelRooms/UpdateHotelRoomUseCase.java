package com.poo.ifsp.poo_hotel_project.usecases.hotelRooms;

import com.poo.ifsp.poo_hotel_project.domain.entities.HotelRoom;
import com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories.HotelRoomRepository;
import com.poo.ifsp.poo_hotel_project.dtos.hotelRooms.UpdateHotelRoomDto;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UpdateHotelRoomUseCase {
  private final HotelRoomRepository hotelRoomRepository;

  public UpdateHotelRoomUseCase(HotelRoomRepository hotelRoomRepository) {
    this.hotelRoomRepository = hotelRoomRepository;
  }

  @Transactional
  public Optional<HotelRoom> execute(UUID id, UpdateHotelRoomDto dto) {
    return hotelRoomRepository.findById(id).map(existingRoom -> {
      existingRoom.updateFromDto(dto);
      return hotelRoomRepository.save(existingRoom);
    });
  }
}
