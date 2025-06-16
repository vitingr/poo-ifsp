package com.poo.ifsp.poo_hotel_project.usecases.guests;

import com.poo.ifsp.poo_hotel_project.domain.interfaces.repositories.GuestRepository;
import com.poo.ifsp.poo_hotel_project.domain.models.Guest;
import com.poo.ifsp.poo_hotel_project.dtos.guest.UpdateGuestDto;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UpdateGuestUseCase {

    private final GuestRepository repository;

    public UpdateGuestUseCase(GuestRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Optional<Guest> execute(UUID id, UpdateGuestDto dto) {
        return repository.findById(id)
                .map(guest -> {
                    guest.setPhone(dto.phone());
                    guest.setEmail(dto.email());
                    guest.setAddress(dto.address());
                    return guest;
                });
    }
}
