package com.user.weather.exceptions;

public class UserNotFound extends RuntimeException {
  public UserNotFound(String message) {
    super(message);
  }
}