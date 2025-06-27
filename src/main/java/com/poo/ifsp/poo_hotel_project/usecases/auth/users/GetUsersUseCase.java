package com.poo.ifsp.poo_hotel_project.usecases.auth.users;

import com.poo.ifsp.poo_hotel_project.domain.entities.User;
import com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GetUsersUseCase {
  private final UserRepository userRepository;

  public GetUsersUseCase(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<User> findAll() {
    return userRepository.findAll();
  }

  public Optional<User> findById(UUID id) {
    return userRepository.findById(id);
  }
}
