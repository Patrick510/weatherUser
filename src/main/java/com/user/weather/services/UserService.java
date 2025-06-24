package com.user.weather.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.weather.dto.UserDTO;
import com.user.weather.dto.UserResponseDTO;
import com.user.weather.exceptions.UserNotFound;
import com.user.weather.models.UserModel;
import com.user.weather.repositories.UserRepository;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public UserResponseDTO createUser(UserDTO userDTO) {
    UserModel user = new UserModel();
    user.setName(userDTO.getName());
    user.setPassword(userDTO.getPassword());

    UserModel savedUser = userRepository.save(user);

    UserResponseDTO response = new UserResponseDTO();
    response.setId(savedUser.getId());
    response.setName(savedUser.getName());

    return response;
  }

  public UserResponseDTO getUserById(Long id) {
    UserModel user = userRepository.findById(id)
        .orElseThrow(() -> new UserNotFound("User not found"));
    UserResponseDTO response = new UserResponseDTO();
    response.setId(user.getId());
    response.setName(user.getName());
    return response;
  }

  public void deleteUser(Long id) {
    UserModel user = userRepository.findById(id)
        .orElseThrow(() -> new UserNotFound("User not found"));
    userRepository.delete(user);
  }

  public UserResponseDTO updateUser(Long id, UserDTO userDTO) {
    UserModel user = userRepository.findById(id)
        .orElseThrow(() -> new UserNotFound("User not found"));
    user.setName(userDTO.getName());
    user.setPassword(userDTO.getPassword());

    UserModel updatedUser = userRepository.save(user);

    UserResponseDTO response = new UserResponseDTO();
    response.setId(updatedUser.getId());
    response.setName(updatedUser.getName());

    return response;
  }

  public UserModel findByName(String name) {
    UserModel user = userRepository.findByName(name);
    if (user == null) {
      throw new UserNotFound("User not found");
    }
    return user;
  }

  public UserModel authenticate(String name, String password) {
    UserModel user = userRepository.findByName(name);
    if (user == null) {
      throw new UserNotFound("User not found");
    }

    if (!user.getPassword().equals(password)) {
      throw new UserNotFound("Invalid password");
    }

    return user;
  }
}
