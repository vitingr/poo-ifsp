package com.poo.ifsp.poo_hotel_project.usecases.hotelRooms;

import com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories.HotelRoomRepository;
import com.poo.ifsp.poo_hotel_project.domain.models.HotelRoom;
import com.poo.ifsp.poo_hotel_project.dtos.hotelRoom.CreateHotelRoomDto;
import com.poo.ifsp.poo_hotel_project.mappers.hotelRoom.CreateHotelRoomMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CreateHotelRoomUseCase {
  private final CreateHotelRoomMapper hotelRoomMapper;
  private final HotelRoomRepository hotelRoomRepository;

  public CreateHotelRoomUseCase(CreateHotelRoomMapper hotelRoomMapper, HotelRoomRepository hotelRoomRepository) {
    this.hotelRoomMapper = hotelRoomMapper;
    this.hotelRoomRepository = hotelRoomRepository;
  }

  @Transactional
  public HotelRoom execute(CreateHotelRoomDto dto) {
    HotelRoom hotelRoom = hotelRoomMapper.toEntity(dto);
    return hotelRoomRepository.save(hotelRoom);
  }
}
