package com.poo.ifsp.poo_hotel_project.usecases.reservations;

import com.poo.ifsp.poo_hotel_project.domain.entities.HotelRoom;
import com.poo.ifsp.poo_hotel_project.domain.entities.Reservation;
import com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories.HotelRoomRepository;
import com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class CancelReservationUseCase {
    private final ReservationRepository reservationRepository;
    private final HotelRoomRepository hotelRoomRepository;

    public CancelReservationUseCase(ReservationRepository reservationRepository,
                                    HotelRoomRepository hotelRoomRepository) {
        this.reservationRepository = reservationRepository;
        this.hotelRoomRepository = hotelRoomRepository;
    }

    @Transactional
    public boolean cancel(UUID reservationId) {
        Optional<Reservation> reservationOpt = reservationRepository.findById(reservationId);
        if (reservationOpt.isEmpty()) {
            return false;
        }
        Reservation reservation = reservationOpt.get();

        UUID roomId = reservation.getRoom_id();
        HotelRoom room = hotelRoomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("Room not found with id: " + roomId));
        room.setIs_available(true);
        hotelRoomRepository.save(room);

        reservationRepository.delete(reservation);
        return true;
    }
}
