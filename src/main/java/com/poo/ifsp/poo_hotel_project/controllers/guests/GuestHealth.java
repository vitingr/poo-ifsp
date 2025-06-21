package com.poo.ifsp.poo_hotel_project.controllers.hotelRooms;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GuestHealth {
  @GetMapping("/guests/health")
  public String healthRoute() {
    return "Healthy";
  }
}
