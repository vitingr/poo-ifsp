package com.poo.ifsp.poo_hotel_project.controllers.checkins;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckin {
  @GetMapping("/checkins/health")
  public String healthRoute() {
    return "Healthy";
  }
}
