package com.user.weather.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class UserModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String password;

  @OneToMany(mappedBy = "user")
  private List<SearchHistory> searchHistorys; // Deixar parado por enquanto, pois não é necessário para o projeto atual
}
