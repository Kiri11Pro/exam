package com.pronchenko.top.soilcare.soilcare.repository;

import com.pronchenko.top.soilcare.soilcare.entity.SoilAnalysis;
import com.pronchenko.top.soilcare.soilcare.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface UserRepository extends JpaRepository<User, Long> {
    // Возвращаем Optional<User> вместо User
    Optional<User> findByUsername(String username);

    // Дополнительные методы при необходимости
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
