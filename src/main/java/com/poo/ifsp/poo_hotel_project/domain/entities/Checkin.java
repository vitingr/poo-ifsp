package com.poo.ifsp.poo_hotel_project.domain.entities;

import jakarta.persistence.*;
import jakarta.persistence.GenerationType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_checkins")
public class Checkin implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Column(nullable = false)
  private UUID guest_id;

  @Column(nullable = false)
  private UUID room_id;

  @Column(nullable = false)
  private LocalDateTime checkin_date;

  @Column(nullable = false)
  private LocalDateTime checkout_estimated;

  @Column(nullable = true)
  private LocalDateTime checkout_date;

  @Column(precision = 10, scale = 2, nullable = false)
  private BigDecimal total_price;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public UUID getGuest_id() {
    return guest_id;
  }

  public void setGuest_id(UUID guest_id) {
    this.guest_id = guest_id;
  }

  public UUID getRoom_id() {
    return room_id;
  }

  public void setRoom_id(UUID room_id) {
    this.room_id = room_id;
  }

  public LocalDateTime getCheckin_date() {
    return checkin_date;
  }

  public void setCheckin_date(LocalDateTime checkin_date) {
    this.checkin_date = checkin_date;
  }

  public LocalDateTime getCheckout_estimated() {
    return checkout_estimated;
  }

  public void setCheckout_estimated(LocalDateTime checkout_estimated) {
    this.checkout_estimated = checkout_estimated;
  }

  public LocalDateTime getCheckout_date() {
    return checkout_date;
  }

  public void setCheckout_date(LocalDateTime checkout_date) {
    this.checkout_date = checkout_date;
  }

  public BigDecimal getTotal_price() {
    return total_price;
  }

  public void setTotal_price(BigDecimal total_price) {
    this.total_price = total_price;
  }
}