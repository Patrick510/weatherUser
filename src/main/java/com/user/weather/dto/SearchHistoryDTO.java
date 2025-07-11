package com.user.weather.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class SearchHistoryDTO {
  private Long id;
  private String city;
  private LocalDateTime date;
  private String weather;
  private String wind;

}
