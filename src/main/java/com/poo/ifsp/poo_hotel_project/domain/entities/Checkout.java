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
  private UUID guest_id;

  @Column(nullable = false)
  private UUID room_id;

  @Column(nullable = false)
  private LocalDateTime checkout_date;

  @Column(nullable = false)
  private LocalDateTime checkout_estimated;

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

  public LocalDateTime getCheckout_date() {
    return checkout_date;
  }

  public void setCheckout_date(LocalDateTime checkout_date) {
    this.checkout_date = checkout_date;
  }

  public LocalDateTime getCheckout_estimated() {
    return checkout_estimated;
  }

  public void setCheckout_estimated(LocalDateTime checkout_estimated) {
    this.checkout_estimated = checkout_estimated;
  }

  public BigDecimal getTotal_price() {
    return total_price;
  }

  public void setTotal_price(BigDecimal total_price) {
    this.total_price = total_price;
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
    if (dto.checkout_estimated() != null) {
      this.setCheckout_estimated(dto.checkout_estimated());
    }
    if (dto.total_price() != null) {
      this.setTotal_price(dto.total_price());
    }
  }
}
