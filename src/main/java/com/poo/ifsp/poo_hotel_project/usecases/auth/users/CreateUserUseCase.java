package com.poo.ifsp.poo_hotel_project.usecases.auth.users;

import com.poo.ifsp.poo_hotel_project.domain.entities.User;
import com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories.UserRepository;
import com.poo.ifsp.poo_hotel_project.dtos.auth.user.CreateUserDto;
import com.poo.ifsp.poo_hotel_project.mappers.auth.users.CreateUserMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCase {
  private final CreateUserMapper createUserMapper;
  private final UserRepository userRepository;

  public CreateUserUseCase(CreateUserMapper createUserMapper, UserRepository userRepository) {
    this.createUserMapper = createUserMapper;
    this.userRepository = userRepository;
  }

  @Transactional
  public User execute(CreateUserDto dto) {
    User user = createUserMapper.toEntity(dto);
    return userRepository.save(user);
  }
}
