package com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories;

import com.poo.ifsp.poo_hotel_project.domain.models.HotelRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HotelRoomRepository extends JpaRepository<HotelRoom, UUID> {

}
