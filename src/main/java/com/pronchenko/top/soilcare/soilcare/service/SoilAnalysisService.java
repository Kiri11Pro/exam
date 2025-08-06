package com.pronchenko.top.soilcare.soilcare.service;

import com.pronchenko.top.soilcare.soilcare.dto.SoilAnalysisDTO;
import com.pronchenko.top.soilcare.soilcare.entity.SoilAnalysis;
import com.pronchenko.top.soilcare.soilcare.entity.User;
import com.pronchenko.top.soilcare.soilcare.repository.SoilAnalysisRepository;
import com.pronchenko.top.soilcare.soilcare.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor // Генерирует конструктор для final полей
@Slf4j // Для логгирования
public class SoilAnalysisService {
    private final SoilAnalysisRepository soilAnalysisRepository;
    private final UserRepository userRepository;

    public SoilAnalysis saveAnalysis(SoilAnalysisDTO dto) {
        // Преобразование DTO в Entity
        SoilAnalysis analysis = new SoilAnalysis();
        analysis.setPh(dto.getPh());
        analysis.setNitrogen(dto.getNitrogen());
        analysis.setPhosphorus(dto.getPhosphorus());
        analysis.setPotassium(dto.getPotassium());
        analysis.setCreatedAt(LocalDateTime.now());

        // Если нужно привязать к текущему пользователю:
        // Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // User user = userRepository.findByUsername(authentication.getName());
        // analysis.setUser(user);

        return soilAnalysisRepository.save(analysis);
    }
}

//    public List<SoilAnalysis> getUserAnalyses(String username) {
//        User user = userRepository.findByUsername(username)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
//
//        return soilAnalysisRepository.findByUser(user);
//    }

