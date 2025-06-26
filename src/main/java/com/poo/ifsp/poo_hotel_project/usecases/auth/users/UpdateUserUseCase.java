package com.poo.ifsp.poo_hotel_project.usecases.auth.users;

import com.poo.ifsp.poo_hotel_project.domain.entities.User;
import com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories.UserRepository;
import com.poo.ifsp.poo_hotel_project.dtos.auth.user.UpdateUserDto;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UpdateUserUseCase {
  private final UserRepository userRepository;

  public UpdateUserUseCase(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Transactional
  public Optional<User> execute(UUID id, UpdateUserDto dto) {
    return userRepository.findById(id).map(user -> {
      user.updateFromDto(dto);
      return userRepository.save(user);
    });
  }
}
