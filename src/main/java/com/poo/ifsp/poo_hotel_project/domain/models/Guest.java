package com.poo.ifsp.poo_hotel_project.domain.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_guests")
public class Guest implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Column(nullable = false)
  private String full_name;

  @Column(nullable = false, unique = true)
  private String document;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  private String phone;

  @Column(nullable = false)
  private String address;

  @Column(nullable = false)
  private LocalDate birth_date;

  @Column(nullable = false)
  private boolean is_active = true;

  @Column(nullable = false, updatable = false)
  private LocalDateTime created_at;

  @Column()
  private LocalDateTime updated_at;

  @PrePersist
  protected void onCreate() {
    this.created_at = LocalDateTime.now();
    this.updated_at = LocalDateTime.now();
  }

  @PreUpdate
  protected void onUpdate() {
    this.updated_at = LocalDateTime.now();
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getFull_name() {
    return full_name;
  }

  public void setFull_name(String full_name) {
    this.full_name = full_name;
  }

  public String getDocument() {
    return document;
  }

  public void setDocument(String document) {
    this.document = document;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public LocalDate getBirth_date() {
    return birth_date;
  }

  public void setBirth_date(LocalDate birth_date) {
    this.birth_date = birth_date;
  }

  public boolean isIs_active() {
    return is_active;
  }

  public void setIs_active(boolean is_active) {
    this.is_active = is_active;
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
