package com.user.weather.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.weather.dto.UserDTO;
import com.user.weather.dto.UserResponseDTO;
import com.user.weather.services.UserService;

@RestController
@RequestMapping("/users")
public class UserControllers {

  @Autowired
  private UserService userService;

  @PostMapping
  public UserResponseDTO createUser(@RequestBody UserDTO userDTO) {
    return userService.createUser(userDTO);
  }

  @GetMapping
  public List<UserResponseDTO> getAllUsers() {
    return userService.getAllUsers();
  }

  @GetMapping("/{id}")
  public UserResponseDTO getUserById(@PathVariable Long id) {
    return userService.getUserById(id);
  }

  @PutMapping("/{id}")
  public UserResponseDTO updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
    return userService.updateUser(id, userDTO);
  }

  @DeleteMapping("/{id}")
  public void deleteUser(@PathVariable Long id) {
    userService.deleteUser(id);
  }
}
