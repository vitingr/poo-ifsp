package com.poo.ifsp.poo_hotel_project.usecases.checkins;

import com.poo.ifsp.poo_hotel_project.domain.entities.Checkin;
import com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories.CheckinRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GetCheckinsUseCase {
  private final CheckinRepository checkinRepository;

  public GetCheckinsUseCase(CheckinRepository checkinRepository) {
    this.checkinRepository = checkinRepository;
  }

  public List<Checkin> findAll() {
    return checkinRepository.findAll();
  }

  public Optional<Checkin> findById(UUID id) {
    return checkinRepository.findById(id);
  }
}
