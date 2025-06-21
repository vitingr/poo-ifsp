package com.poo.ifsp.poo_hotel_project.controllers.hotelRooms;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotel-rooms")
public class HealthHotelRoom {
  @GetMapping("/health")
  public String healthRoute() {
    return "Healthy";
  }
}
