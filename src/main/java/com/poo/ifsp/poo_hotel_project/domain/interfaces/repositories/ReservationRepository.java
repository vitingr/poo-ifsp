package com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories;

import com.poo.ifsp.poo_hotel_project.domain.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, UUID> {
  @Query("""
  SELECT r FROM Reservation r
  WHERE r.room_id = :roomId
    AND r.status IN ('PENDING', 'ACTIVE')
    AND r.start_date < :endDate
    AND r.end_date > :startDate
""")
  List<Reservation> findConflictingReservations(
     @Param("roomId") UUID roomId,
     @Param("startDate") LocalDateTime startDate,
     @Param("endDate") LocalDateTime endDate
  );
}
