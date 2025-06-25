package com.poo.ifsp.poo_hotel_project.usecases.checkins;

import com.poo.ifsp.poo_hotel_project.domain.entities.Checkin;
import com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories.CheckinRepository;
import com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories.GuestRepository;
import com.poo.ifsp.poo_hotel_project.dtos.checkins.GetCheckinDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GetCheckinsUseCase {
  private final CheckinRepository checkinRepository;
  private final GuestRepository guestRepository;

  public GetCheckinsUseCase(CheckinRepository checkinRepository, GuestRepository guestRepository) {
    this.checkinRepository = checkinRepository;
    this.guestRepository = guestRepository;
  }

  public List<GetCheckinDto> findAllWithGuest() {
    List<Checkin> checkins = checkinRepository.findAll();

    return checkins.stream().map(checkin -> {
      var guest = guestRepository.findById(checkin.getGuest_id()).orElse(null);

      return new GetCheckinDto(
        checkin.getId(),
        checkin.getGuest_id(),
        checkin.getReservation_id(),
        checkin.getRoom_id(),
        checkin.getCheckin_date(),
        checkin.getCheckout_estimated(),
        guest != null ? guest.getFull_name() : "Desconhecido"
      );
    }).toList();
  }

  public Optional<Checkin> findById(UUID id) {
    return checkinRepository.findById(id);
  }
}
