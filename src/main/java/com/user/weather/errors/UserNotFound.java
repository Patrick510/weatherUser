package com.user.weather.errors;

public class UserNotFound extends RuntimeException {
  public UserNotFound(String message) {
    super(message);
  }
}