package com.poo.ifsp.poo_hotel_project.mappers.checkins;

import com.poo.ifsp.poo_hotel_project.domain.entities.Checkin;
import com.poo.ifsp.poo_hotel_project.dtos.checkins.GetCheckinDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GetCheckinMapper {
    GetCheckinDto toDto(Checkin checkin);
    java.util.List<GetCheckinDto> toDtoList(java.util.List<Checkin> checkins);
}
