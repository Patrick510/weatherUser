package com.user.weather.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.weather.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {
  com.user.weather.models.UserModel findByName(String name);

  com.user.weather.models.UserModel findByNameAndPassword(String name, String password);

}
