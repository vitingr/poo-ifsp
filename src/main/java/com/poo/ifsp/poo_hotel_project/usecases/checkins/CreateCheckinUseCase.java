package com.poo.ifsp.poo_hotel_project.usecases.checkins;

import com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories.CheckinRepository;
import com.poo.ifsp.poo_hotel_project.dtos.checkins.CreateCheckinDto;
import com.poo.ifsp.poo_hotel_project.mappers.checkins.CreateCheckinMapper;
import com.poo.ifsp.poo_hotel_project.domain.entities.Checkin;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CreateCheckinUseCase {
  private final CreateCheckinMapper checkinMapper;
  private final CheckinRepository checkinRepository;

  public CreateCheckinUseCase(CreateCheckinMapper checkinMapper, CheckinRepository checkinRepository) {
    this.checkinMapper = checkinMapper;
    this.checkinRepository = checkinRepository;
  }

  @Transactional
  public Checkin execute(CreateCheckinDto dto) {
    Checkin checkin = checkinMapper.toEntity(dto);
    return checkinRepository.save(checkin);
  }
}
