package com.poo.ifsp.poo_hotel_project.mappers.auth.users;

import com.poo.ifsp.poo_hotel_project.domain.entities.User;
import com.poo.ifsp.poo_hotel_project.dtos.auth.user.CreateUserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreateUserMapper {
  User toEntity(CreateUserDto dto);

  User toDto(User user);
}
