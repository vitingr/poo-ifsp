package com.poo.ifsp.poo_hotel_project.usecases.auth.users;

import com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteUserUseCase {
  private final UserRepository userRepository;

  public DeleteUserUseCase(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Transactional
  public boolean execute(UUID id) {
    if (!userRepository.existsById(id)) return false;
    userRepository.deleteById(id);
    return true;
  }
}
