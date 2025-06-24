package com.user.weather.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.weather.models.SearchHistory;

public interface HistoryRepository extends JpaRepository<SearchHistory, Long> {
  List<SearchHistory> findByUserId(Long userId);
}
