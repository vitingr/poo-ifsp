package com.poo.ifsp.poo_hotel_project.controllers.auth.users;

import com.poo.ifsp.poo_hotel_project.dtos.auth.user.GetUserDto;
import com.poo.ifsp.poo_hotel_project.mappers.auth.users.GetUserMapper;
import com.poo.ifsp.poo_hotel_project.usecases.auth.users.GetUsersUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class GetUsers {
  private final GetUsersUseCase getUsersUseCase;

  private final GetUserMapper getUserMapper;

  public GetUsers(GetUsersUseCase getUsersUseCase, GetUserMapper getUserMapper) {
    this.getUserMapper = getUserMapper;
    this.getUsersUseCase = getUsersUseCase;
  }

  @GetMapping
  public ResponseEntity<List<GetUserDto>> getAll() {
    var users = getUsersUseCase.findAll();
    return ResponseEntity.ok(getUserMapper.toDtoList(users));
  }

  @GetMapping("/{id}")
  public ResponseEntity<GetUserDto> getById(@PathVariable UUID id) {
    return getUsersUseCase.findById(id)
      .map(user -> ResponseEntity.ok(getUserMapper.toDto(user)))
      .orElse(ResponseEntity.notFound().build());
  }
}
