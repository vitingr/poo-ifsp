package com.poo.ifsp.poo_hotel_project.controllers.auth.users;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserHealth {
  @GetMapping("/health")
  public String healthRoute() {
    return "Healthy";
  }
}
