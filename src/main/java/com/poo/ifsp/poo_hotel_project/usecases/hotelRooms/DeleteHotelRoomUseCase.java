package com.poo.ifsp.poo_hotel_project.usecases.hotelRooms;

import com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories.HotelRoomRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteHotelRoomUseCase {
  private final HotelRoomRepository hotelRoomRepository;

  public DeleteHotelRoomUseCase(HotelRoomRepository hotelRoomRepository) {
    this.hotelRoomRepository = hotelRoomRepository;
  }

  @Transactional
  public boolean execute(UUID id) {
    if (!hotelRoomRepository.existsById(id)) return false;
    hotelRoomRepository.deleteById(id);
    return true;
  }
}
