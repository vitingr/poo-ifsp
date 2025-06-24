package com.poo.ifsp.poo_hotel_project.mappers.reservations;

import com.poo.ifsp.poo_hotel_project.domain.entities.Reservation;
import com.poo.ifsp.poo_hotel_project.dtos.reservations.GetReservationDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GetReservationMapper {
  GetReservationDto toDto(Reservation reservation);

  List<GetReservationDto> toDtoList(List<Reservation> reservations);
}
