package com.poo.ifsp.poo_hotel_project.usecases.guests;

import com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories.GuestRepository;
import com.poo.ifsp.poo_hotel_project.domain.entities.Guest;
import com.poo.ifsp.poo_hotel_project.dtos.guests.CreateGuestDto;
import com.poo.ifsp.poo_hotel_project.mappers.guests.CreateGuestMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CreateGuestUseCase {
  private final CreateGuestMapper guestMapper;
  private final GuestRepository guestRepository;

  public CreateGuestUseCase(CreateGuestMapper guestMapper, GuestRepository guestRepository) {
    this.guestMapper = guestMapper;
    this.guestRepository = guestRepository;
  }

  @Transactional
  public Guest execute(CreateGuestDto dto) {
    Guest guest = guestMapper.toEntity(dto);
    return guestRepository.save(guest);
  }
}
