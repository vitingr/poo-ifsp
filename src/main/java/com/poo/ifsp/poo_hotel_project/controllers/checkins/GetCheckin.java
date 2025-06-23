package com.poo.ifsp.poo_hotel_project.controllers.checkins;

import com.poo.ifsp.poo_hotel_project.dtos.checkins.GetCheckinDto;
import com.poo.ifsp.poo_hotel_project.mappers.checkins.GetCheckinMapper;
import com.poo.ifsp.poo_hotel_project.usecases.checkins.GetCheckinUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/checkins")
public class GetCheckin {
    private final GetCheckinUseCase getCheckinUseCase;
    private final GetCheckinMapper getCheckinMapper;

    public GetCheckin(GetCheckinUseCase getCheckinUseCase, GetCheckinMapper getCheckinMapper) {
        this.getCheckinUseCase = getCheckinUseCase;
        this.getCheckinMapper = getCheckinMapper;
    }

    @GetMapping
    public ResponseEntity<List<GetCheckinDto>> getAll() {
        var checkins = getCheckinUseCase.findAll();
        return ResponseEntity.ok(getCheckinMapper.toDtoList(checkins));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetCheckinDto> getById(@PathVariable UUID id) {
        return getCheckinUseCase.findById(id)
                .map(checkin -> ResponseEntity.ok(getCheckinMapper.toDto(checkin)))
                .orElse(ResponseEntity.notFound().build());
    }
}
