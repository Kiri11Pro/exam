package com.pronchenko.top.soilcare.soilcare.repository;

import com.pronchenko.top.soilcare.soilcare.entity.SoilAnalysis;
import com.pronchenko.top.soilcare.soilcare.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SoilAnalysisRepository extends JpaRepository<SoilAnalysis, Long> {
    // Правильное объявление метода для поиска по пользователю
    List<SoilAnalysis> findByUser(User user);
}
