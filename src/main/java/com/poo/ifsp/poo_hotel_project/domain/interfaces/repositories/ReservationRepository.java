package com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories;

import com.poo.ifsp.poo_hotel_project.domain.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReservationRepository extends JpaRepository<Reservation, UUID> {
}
