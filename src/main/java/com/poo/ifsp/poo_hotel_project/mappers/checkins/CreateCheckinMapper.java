package com.poo.ifsp.poo_hotel_project.mappers.checkins;

import com.poo.ifsp.poo_hotel_project.domain.entities.Checkin;
import com.poo.ifsp.poo_hotel_project.dtos.checkins.CreateCheckinDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreateCheckinMapper {
  Checkin toEntity(CreateCheckinDto dto);

  Checkin toDto(Checkin checkin);
}
