package com.poo.ifsp.poo_hotel_project.mappers.auth.users;

import com.poo.ifsp.poo_hotel_project.domain.entities.User;
import com.poo.ifsp.poo_hotel_project.dtos.auth.user.GetUserDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GetUserMapper {
  GetUserDto toDto(User user);

  List<GetUserDto> toDtoList(List<User> users);
}
