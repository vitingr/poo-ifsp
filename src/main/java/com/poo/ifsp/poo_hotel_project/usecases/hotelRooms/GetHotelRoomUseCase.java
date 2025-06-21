package com.poo.ifsp.poo_hotel_project.usecases.hotelRooms;

import com.poo.ifsp.poo_hotel_project.domain.entities.HotelRoom;
import com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories.HotelRoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GetHotelRoomUseCase {
  private final HotelRoomRepository hotelRoomRepository;

  public GetHotelRoomUseCase(HotelRoomRepository hotelRoomRepository) {
    this.hotelRoomRepository = hotelRoomRepository;
  }

  public List<HotelRoom> findAll() {
    return hotelRoomRepository.findAll();
  }

  public Optional<HotelRoom> findById(UUID id) {
    return hotelRoomRepository.findById(id);
  }
}
