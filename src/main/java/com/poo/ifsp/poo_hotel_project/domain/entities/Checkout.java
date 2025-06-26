package com.poo.ifsp.poo_hotel_project.domain.entities;

import com.poo.ifsp.poo_hotel_project.dtos.checkouts.UpdateCheckoutDto;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_checkouts")
public class Checkout implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Column(nullable = false)
  private UUID reservation_id;

  @Column(nullable = false, insertable = false, updatable = false)
  private UUID guest_id;

  @Column(nullable = false, insertable = false, updatable = false)
  private UUID room_id;

  @Column(nullable = false)
  private LocalDateTime checkout_date;

  @Column(precision = 10, scale = 2, nullable = false)
  private BigDecimal total_price;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "guest_id", nullable = false)
  private Guest guest;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "room_id", nullable = false)
  private HotelRoom room;

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

  public UUID getReservation_id() {
    return reservation_id;
  }

  public void setReservation_id(UUID reservation_id) {
    this.reservation_id = reservation_id;
  }

  public Guest getGuest() {
    return guest;
  }

  public void setGuest(Guest guest) {
    this.guest = guest;
  }

  public HotelRoom getRoom() {
    return room;
  }

  public void setRoom(HotelRoom room) {
    this.room = room;
  }

  public void updateFromDto(UpdateCheckoutDto dto) {
    if (dto.guest_id() != null) {
      this.setGuest_id(dto.guest_id());
    }
    if (dto.room_id() != null) {
      this.setRoom_id(dto.room_id());
    }
    if (dto.checkout_date() != null) {
      this.setCheckout_date(dto.checkout_date());
    }
    if (dto.total_price() != null) {
      this.setTotal_price(dto.total_price());
    }
  }
}
