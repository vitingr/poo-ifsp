package com.poo.ifsp.poo_hotel_project.mappers.reservations;

import com.poo.ifsp.poo_hotel_project.domain.entities.Reservation;
import com.poo.ifsp.poo_hotel_project.dtos.reservations.GetReservationDto;
import org.mapstruct.Mapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface GetReservationMapper {

    default GetReservationDto toDto(Reservation reservation) {
        boolean expired = reservation.getEnd_date().isBefore(LocalDateTime.now());
        return new GetReservationDto(
                reservation.getId(),
                reservation.getGuest_id(),
                reservation.getRoom_id(),
                reservation.getStart_date(),
                reservation.getEnd_date(),
                reservation.getTotal_price(),
                expired
        );
    }

    default List<GetReservationDto> toDtoList(List<Reservation> reservations) {
        return reservations.stream().map(this::toDto).collect(Collectors.toList());
    }
}
