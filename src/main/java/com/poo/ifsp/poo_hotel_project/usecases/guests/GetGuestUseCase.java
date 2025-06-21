package com.poo.ifsp.poo_hotel_project.usecases.guests;

import com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories.GuestRepository;
import com.poo.ifsp.poo_hotel_project.domain.entities.Guest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GetGuestUseCase {
  private final GuestRepository repository;

  public GetGuestUseCase(GuestRepository repository) {
    this.repository = repository;
  }

  public List<Guest> findAll() {
    return repository.findAll();
  }

  public Optional<Guest> findById(UUID id) {
    return repository.findById(id);
  }
}
