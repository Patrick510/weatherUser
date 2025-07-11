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
    history.setCountry(dto.getCountry());
    history.setWeatherDescription(dto.getWeatherDescription());
    history.setWeatherIcon(dto.getWeatherIcon());
    history.setTemperature(dto.getTemperature());
    history.setWindSpeed(dto.getWindSpeed());
    history.setLon(dto.getLon());
    history.setLat(dto.getLat());
    history.setDate(LocalDateTime.now());
    history.setUser(user);

    historyRepository.save(history);
  }

  public List<SearchHistoryDTO> getHistoryByUserId(Long userId) {
    List<SearchHistory> histories = historyRepository.findByUserId(userId);

    return histories.stream().map(h -> {
      SearchHistoryDTO dto = new SearchHistoryDTO();
      dto.setId(h.getId());
      dto.setCity(h.getCity());
      dto.setCountry(h.getCountry());
      dto.setWeatherDescription(h.getWeatherDescription());
      dto.setWeatherIcon(h.getWeatherIcon());
      dto.setTemperature(h.getTemperature());
      dto.setWindSpeed(h.getWindSpeed());
      dto.setLon(h.getLon());
      dto.setLat(h.getLat());
      dto.setDate(h.getDate());
      return dto;
    }).toList();
  }

}
