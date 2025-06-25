package com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories;

import com.poo.ifsp.poo_hotel_project.domain.entities.HotelRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface HotelRoomRepository extends JpaRepository<HotelRoom, UUID> {
  long countByFloor(int floor);

  @Query("SELECT hr FROM HotelRoom hr WHERE hr.is_available = true")
  List<HotelRoom> findAvailableRooms();

  @Query("SELECT hr FROM HotelRoom hr WHERE hr.is_available = false")
  List<HotelRoom> findUnavailableRooms();
}
