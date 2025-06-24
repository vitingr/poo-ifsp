package com.poo.ifsp.poo_hotel_project.mappers.reservations;

import com.poo.ifsp.poo_hotel_project.domain.entities.Reservation;
import com.poo.ifsp.poo_hotel_project.dtos.reservations.CreateReservationDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CreateReservationMapper {
  @Mapping(target = "total_price", ignore = true)
  Reservation toEntity(CreateReservationDto dto);

  Reservation toDto(Reservation reservation);
}
