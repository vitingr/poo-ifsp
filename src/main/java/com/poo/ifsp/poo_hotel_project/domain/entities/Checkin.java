package com.poo.ifsp.poo_hotel_project.domain.entities;

import com.poo.ifsp.poo_hotel_project.dtos.checkins.UpdateCheckinDto;
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
  private UUID reservation_id;

  @Column(nullable = false, insertable = false, updatable = false)
  private UUID guest_id;

  @Column(nullable = false)
  private UUID room_id;

  @Column(nullable = false)
  private LocalDateTime checkin_date;

  @Column(nullable = false)
  private LocalDateTime checkout_estimated;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "guest_id", nullable = false)
  private Guest guest;

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

  public UUID getReservation_id() {
    return reservation_id;
  }

  public void setReservation_id(UUID reservation_id) {
    this.reservation_id = reservation_id;
  }

  public void updateFromDto(UpdateCheckinDto dto) {
    if (dto.guest_id() != null) this.setGuest_id(dto.guest_id());
    if (dto.room_id() != null) this.setRoom_id(dto.room_id());
    if (dto.checkin_date() != null) this.setCheckin_date(dto.checkin_date());
    if (dto.checkout_estimated() != null) this.setCheckout_estimated(dto.checkout_estimated());
  }
}