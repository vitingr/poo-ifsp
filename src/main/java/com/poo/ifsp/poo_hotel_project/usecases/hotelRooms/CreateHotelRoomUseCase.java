package com.poo.ifsp.poo_hotel_project.usecases.hotelRooms;

import com.poo.ifsp.poo_hotel_project.domain.enums.RoomType;
import com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories.HotelRoomRepository;
import com.poo.ifsp.poo_hotel_project.domain.entities.HotelRoom;
import com.poo.ifsp.poo_hotel_project.dtos.hotelRooms.CreateHotelRoomDto;
import com.poo.ifsp.poo_hotel_project.mappers.hotelRooms.CreateHotelRoomMapper;
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

  private String generateRoomCode(int floor, RoomType roomType) {
    char floorLetter = (char) ('A' + floor - 1);

    long roomsOnFloor = hotelRoomRepository.countByFloor(floor);

    long roomNumber = roomsOnFloor + 1;

    String roomNumberFormatted = String.format("%03d", roomNumber);

    String typeAbbreviation = roomType.name().substring(0, 1);

    return floorLetter + roomNumberFormatted + "-" + typeAbbreviation;
  }

  @Transactional
  public HotelRoom execute(CreateHotelRoomDto dto) {
    String roomCode = generateRoomCode(dto.floor(), dto.room_type());

    HotelRoom hotelRoom = hotelRoomMapper.toEntity(dto);
    hotelRoom.setRoom_code(roomCode);

    return hotelRoomRepository.save(hotelRoom);
  }
}
