package com.poo.ifsp.poo_hotel_project.controllers.reservations;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservations")
public class HealthReservation {
  @GetMapping("/health")
  public String healthRoute() {
    return "Healthy";
  }
}
