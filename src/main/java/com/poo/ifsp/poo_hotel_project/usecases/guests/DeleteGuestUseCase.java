package com.poo.ifsp.poo_hotel_project.usecases.guests;

import com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories.GuestRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteGuestUseCase {
  private final GuestRepository guestRepository;

  public DeleteGuestUseCase(GuestRepository guestRepository) {
    this.guestRepository = guestRepository;
  }

  @Transactional
  public boolean execute(UUID id) {
    if (!guestRepository.existsById(id)) return false;
    guestRepository.deleteById(id);
    return true;
  }
}
