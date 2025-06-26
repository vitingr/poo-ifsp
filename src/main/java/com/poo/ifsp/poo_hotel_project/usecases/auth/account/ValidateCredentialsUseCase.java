package com.poo.ifsp.poo_hotel_project.usecases.auth.account;

import com.poo.ifsp.poo_hotel_project.domain.entities.User;
import com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories.UserRepository;
import com.poo.ifsp.poo_hotel_project.dtos.auth.account.ValidateCredentialsDto;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class ValidateCredentialsUseCase {
  private final UserRepository userRepository;

  public ValidateCredentialsUseCase(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Transactional
  public User execute(@Valid ValidateCredentialsDto dto) {
    User user = userRepository.findByEmail(dto.email())
      .orElseThrow(() -> new IllegalArgumentException("Email not found."));

    if (!user.getPassword().equals(dto.password())) {
      throw new IllegalArgumentException("Incorrect Password.");
    }

    return user;
  }
}
