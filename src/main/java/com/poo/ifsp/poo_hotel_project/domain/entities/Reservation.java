package com.poo.ifsp.poo_hotel_project.domain.entities;

import com.poo.ifsp.poo_hotel_project.domain.enums.ReservationStatus;
import com.poo.ifsp.poo_hotel_project.domain.enums.RoomType;
import com.poo.ifsp.poo_hotel_project.dtos.reservations.UpdateReservationDto;
import jakarta.persistence.*;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_reservations")
public class Reservation implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Column(nullable = false, insertable = false, updatable = false)
  private UUID guest_id;

  @Column(nullable = false, insertable = false, updatable = false)
  private UUID room_id;

  @Column(nullable = false)
  private LocalDateTime start_date;

  @Column(nullable = false)
  private LocalDateTime end_date;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private ReservationStatus status = ReservationStatus.PENDING;

  @Column(precision = 10, scale = 2, nullable = false)
  private BigDecimal total_price;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "guest_id", nullable = false)
  private Guest guest;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "room_id", nullable = false)
  private HotelRoom room;

  @Column(nullable = false, updatable = false)
  private LocalDateTime created_at;

  @Column(nullable = true)
  private LocalDateTime updated_at;

  @PrePersist
  protected void onCreate() {
    this.created_at = LocalDateTime.now();
    this.updated_at = LocalDateTime.now();
  }

  @PreUpdate
  protected void onUpdate() {
    this.created_at = LocalDateTime.now();
  }

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

  public LocalDateTime getStart_date() {
    return start_date;
  }

  public void setStart_date(LocalDateTime start_date) {
    this.start_date = start_date;
  }

  public LocalDateTime getEnd_date() {
    return end_date;
  }

  public void setEnd_date(LocalDateTime end_date) {
    this.end_date = end_date;
  }

  public BigDecimal getTotal_price() {
    return total_price;
  }

  public void setTotal_price(BigDecimal total_price) {
    this.total_price = total_price;
  }

  public LocalDateTime getCreated_at() {
    return created_at;
  }

  public void setCreated_at(LocalDateTime created_at) {
    this.created_at = created_at;
  }

  public LocalDateTime getUpdated_at() {
    return updated_at;
  }

  public void setUpdated_at(LocalDateTime updated_at) {
    this.updated_at = updated_at;
  }

  public ReservationStatus getStatus() {
    return status;
  }

  public void setStatus(ReservationStatus status) {
    this.status = status;
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

  public void updateFromDto(UpdateReservationDto dto) {
    if (dto.guest_id() != null) this.setGuest_id(dto.guest_id());
    if (dto.room_id() != null) this.setRoom_id(dto.room_id());
    if (dto.start_date() != null) this.setStart_date(dto.start_date());
    if (dto.end_date() != null) this.setEnd_date(dto.end_date());
    if (dto.status() != null) this.setStatus(dto.status());
    if (dto.total_price() != null) this.setTotal_price(dto.total_price());

    this.setUpdated_at(LocalDateTime.now());
  }
}