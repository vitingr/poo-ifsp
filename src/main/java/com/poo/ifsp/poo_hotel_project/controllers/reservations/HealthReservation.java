package com.poo.ifsp.poo_hotel_project.controllers.reservations;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthReservation {
  @GetMapping("/reservations/health")
  public String healthRoute() {
    return "Healthy";
  }
}
