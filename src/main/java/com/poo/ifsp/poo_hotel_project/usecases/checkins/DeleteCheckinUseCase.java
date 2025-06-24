package com.poo.ifsp.poo_hotel_project.usecases.checkins;

import com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories.CheckinRepository;
import com.poo.ifsp.poo_hotel_project.usecases.guests.DeleteGuestUseCase;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteCheckinUseCase {
  private final CheckinRepository checkinRepository;

  public DeleteCheckinUseCase(CheckinRepository checkinRepository) {
    this.checkinRepository = checkinRepository;
  }

  @Transactional
  public boolean execute(UUID id) {
    if (!checkinRepository.existsById(id)) return false;
    checkinRepository.deleteById(id);
    return true;
  }
}
