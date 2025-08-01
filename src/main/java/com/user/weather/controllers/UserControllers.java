package com.user.weather.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.weather.dto.SearchHistoryDTO;
import com.user.weather.dto.UserDTO;
import com.user.weather.dto.UserResponseDTO;
import com.user.weather.errors.UserNotFound;
import com.user.weather.models.UserModel;
import com.user.weather.services.HistoryService;
import com.user.weather.services.UserService;

@RestController
@RequestMapping("/users")
public class UserControllers {

  @Autowired
  private UserService userService;

  @Autowired
  private HistoryService historyService;

  @PostMapping
  public UserResponseDTO createUser(@RequestBody UserDTO userDTO) {
    return userService.createUser(userDTO);
  }

  @GetMapping
  public List<UserResponseDTO> getAllUsers() {
    return userService.getAllUsers();
  }

  @PostMapping("/login")
  public ResponseEntity<UserResponseDTO> login(@RequestBody UserDTO userDTO) {
    try {
      UserModel user = userService.authenticate(userDTO.getName(), userDTO.getPassword());

      UserResponseDTO response = new UserResponseDTO();
      response.setId(user.getId());
      response.setName(user.getName());

      return ResponseEntity.ok(response);
    } catch (UserNotFound e) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
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

  @PostMapping("/history/{userId}")
  public ResponseEntity<Void> saveHistory(@PathVariable Long userId, @RequestBody SearchHistoryDTO dto) {
    historyService.saveHistory(userId, dto);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @GetMapping("/history/{userId}")
  public ResponseEntity<List<SearchHistoryDTO>> getUserHistory(@PathVariable Long userId) {
    List<SearchHistoryDTO> histories = historyService.getHistoryByUserId(userId);
    return ResponseEntity.ok(histories);
  }
}
