package com.poo.ifsp.poo_hotel_project.usecases.checkins;

import com.poo.ifsp.poo_hotel_project.domain.entities.Checkin;
import com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories.CheckinRepository;
import com.poo.ifsp.poo_hotel_project.dtos.checkins.UpdateCheckinDto;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UpdateCheckinUseCase {
  private final CheckinRepository checkinRepository;

  public UpdateCheckinUseCase(CheckinRepository checkinRepository) {
    this.checkinRepository = checkinRepository;
  }

  @Transactional
  public Optional<Checkin> execute(UUID id, UpdateCheckinDto dto) {
    return checkinRepository.findById(id).map(checkin -> {
      checkin.updateFromDto(dto);
      return checkinRepository.save(checkin);
    });
  }
}
