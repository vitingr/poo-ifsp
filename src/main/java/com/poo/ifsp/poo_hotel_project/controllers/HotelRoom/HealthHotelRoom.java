package com.poo.ifsp.poo_hotel_project.controllers.HotelRoom;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthHotelRoom {
  @GetMapping("/hotel-rooms/health")
  public String healthRoute() {
    return "Healthy";
  }
}
