package com.user.weather.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDateTime;
import jakarta.persistence.Column;

@Entity
@Data
public class SearchHistory {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String city;

  @Column(columnDefinition = "TIMESTAMP")
  private LocalDateTime date;

  private String weather;
  private String wind;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private UserModel user;
}
