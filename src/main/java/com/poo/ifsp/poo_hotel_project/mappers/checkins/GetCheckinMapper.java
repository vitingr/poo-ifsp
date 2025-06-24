package com.poo.ifsp.poo_hotel_project.mappers.checkins;

import com.poo.ifsp.poo_hotel_project.domain.entities.Checkin;
import com.poo.ifsp.poo_hotel_project.dtos.checkins.GetCheckinDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GetCheckinMapper {
  GetCheckinDto toDto(Checkin checkin);

  List<GetCheckinDto> toDtoList(List<Checkin> checkins);
}
