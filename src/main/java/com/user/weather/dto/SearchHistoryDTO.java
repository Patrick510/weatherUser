package com.user.weather.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class SearchHistoryDTO {
  private Long id;
  private String city;
  private String country;
  private String cep;
  private String weatherDescription;
  private String weatherIcon;
  private Double temperature;
  private Double windSpeed;
  private LocalDateTime date;
  private Double lon;
  private Double lat;
}
