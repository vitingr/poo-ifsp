package com.poo.ifsp.poo_hotel_project.mappers.reservations;

import com.poo.ifsp.poo_hotel_project.domain.entities.Reservation;
import com.poo.ifsp.poo_hotel_project.dtos.reservations.CreateReservationDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreateReservationMapper {
  Reservation toEntity(CreateReservationDto dto);

  Reservation toDto(Reservation reservation);
}
