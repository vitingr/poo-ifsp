package com.poo.ifsp.poo_hotel_project.domain.models;

import com.poo.ifsp.poo_hotel_project.domain.enums.RoomType;
import jakarta.persistence.*;
import java.math.BigDecimal;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_hotel_rooms")
public class HotelRoom implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Column(nullable = false, unique = true)
  private String room_code;

  @Column(nullable = false)
  private int floor;

  @Enumerated(EnumType.STRING)
  @Column( nullable = false)
  private RoomType room_type;

  @Column(nullable = false)
  private int beds_qtd;

  @Column(nullable = false)
  private int max_capacity;

  @Column(precision = 10, scale = 2, nullable = false)
  private BigDecimal price_per_night;

  @Column(nullable = false)
  private boolean is_available = true;

  @Column(columnDefinition = "TEXT")
  private String description;

  @Column(nullable = false)
  private String room_image;

  @Column(nullable = false)
  private boolean has_wifi;

  @Column(nullable = false)
  private boolean has_tv;

  @Column(nullable = false, updatable = false)
  private LocalDateTime created_at;

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

  public String getRoom_code() {
    return room_code;
  }

  public void setRoom_code(String room_code) {
    this.room_code = room_code;
  }

  public int getFloor() {
    return floor;
  }

  public void setFloor(int floor) {
    this.floor = floor;
  }

  public RoomType getRoom_type() {
    return room_type;
  }

  public void setRoom_type(RoomType room_type) {
    this.room_type = room_type;
  }

  public int getBeds_qtd() {
    return beds_qtd;
  }

  public void setBeds_qtd(int beds_qtd) {
    this.beds_qtd = beds_qtd;
  }

  public int getMax_capacity() {
    return max_capacity;
  }

  public void setMax_capacity(int max_capacity) {
    this.max_capacity = max_capacity;
  }

  public BigDecimal getPrice_per_night() {
    return price_per_night;
  }

  public void setPrice_per_night(BigDecimal price_per_night) {
    this.price_per_night = price_per_night;
  }

  public boolean isIs_available() {
    return is_available;
  }

  public void setIs_available(boolean is_available) {
    this.is_available = is_available;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getRoom_image() {
    return room_image;
  }

  public void setRoom_image(String room_image) {
    this.room_image = room_image;
  }

  public boolean isHas_wifi() {
    return has_wifi;
  }

  public void setHas_wifi(boolean has_wifi) {
    this.has_wifi = has_wifi;
  }

  public boolean isHas_tv() {
    return has_tv;
  }

  public void setHas_tv(boolean has_tv) {
    this.has_tv = has_tv;
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
}
