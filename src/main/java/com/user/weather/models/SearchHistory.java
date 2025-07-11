package com.user.weather.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class SearchHistory {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String city;
  private String country; // Novo campo

  private String weatherDescription;
  private String weatherIcon;

  private Double temperature;
  private Double windSpeed;

  private LocalDateTime date; // Data da consulta

  private Double lon; // coordenadas
  private Double lat;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private UserModel user;
}
