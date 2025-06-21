package com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories;

import com.poo.ifsp.poo_hotel_project.domain.entities.Checkin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CheckinRepository extends JpaRepository<Checkin, UUID> {

}
