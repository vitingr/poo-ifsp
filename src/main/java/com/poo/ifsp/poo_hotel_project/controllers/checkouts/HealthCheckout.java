package com.poo.ifsp.poo_hotel_project.controllers.checkouts;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/checkouts")
public class HealthCheckout {
  @GetMapping("/health")
  public String healthRoute() {
    return "Healthy";
  }
}
