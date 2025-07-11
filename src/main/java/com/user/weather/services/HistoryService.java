package com.user.weather.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.weather.dto.SearchHistoryDTO;
import com.user.weather.errors.UserNotFound;
import com.user.weather.models.SearchHistory;
import com.user.weather.models.UserModel;
import com.user.weather.repositories.HistoryRepository;
import com.user.weather.repositories.UserRepository;

@Service
public class HistoryService {

  @Autowired
  private HistoryRepository historyRepository;

  @Autowired
  private UserRepository userRepository;

  public void saveHistory(Long userId, SearchHistoryDTO dto) {
    UserModel user = userRepository.findById(userId)
        .orElseThrow(() -> new UserNotFound("User not found"));

    SearchHistory history = new SearchHistory();
    history.setCity(dto.getCity());
    history.setDate(LocalDateTime.now());
    history.setWeather(dto.getWeather());
    history.setWind(dto.getWind());
    history.setUser(user);

    historyRepository.save(history);
  }

  public List<SearchHistoryDTO> getHistoryByUserId(Long userId) {
    List<SearchHistory> histories = historyRepository.findByUserId(userId);
    return histories.stream().map(h -> {
      SearchHistoryDTO dto = new SearchHistoryDTO();
      dto.setId(h.getId());
      dto.setCity(h.getCity());
      dto.setDate(h.getDate());
      dto.setWeather(h.getWeather());
      dto.setWind(h.getWind());
      return dto;
    }).toList();
  }
}
