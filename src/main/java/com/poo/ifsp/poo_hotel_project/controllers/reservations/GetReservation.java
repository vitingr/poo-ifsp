package com.poo.ifsp.poo_hotel_project.controllers.reservations;

import com.poo.ifsp.poo_hotel_project.dtos.reservations.GetReservationDto;
import com.poo.ifsp.poo_hotel_project.mappers.reservations.GetReservationMapper;
import com.poo.ifsp.poo_hotel_project.usecases.reservations.GetReservationUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/reservations")
public class GetReservation {
    private final GetReservationUseCase getReservationUseCase;
    private final GetReservationMapper getReservationMapper;

    public GetReservation(GetReservationUseCase getReservationUseCase, GetReservationMapper getReservationMapper) {
        this.getReservationUseCase = getReservationUseCase;
        this.getReservationMapper = getReservationMapper;
    }

    @GetMapping
    public ResponseEntity<List<GetReservationDto>> getAll() {
        var reservations = getReservationUseCase.findAll();
        return ResponseEntity.ok(getReservationMapper.toDtoList(reservations));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetReservationDto> getById(@PathVariable UUID id) {
        return getReservationUseCase.findById(id)
                .map(reservation -> ResponseEntity.ok(getReservationMapper.toDto(reservation)))
                .orElse(ResponseEntity.notFound().build());
    }
}
