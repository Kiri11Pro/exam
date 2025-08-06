package com.pronchenko.top.soilcare.soilcare.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
    @Table(name = "users") // Явно указываем имя таблицы в БД
    @Data // Генерирует геттеры, сеттеры, toString, equals, hashCode
    @NoArgsConstructor // Пустой конструктор (требуется для JPA)
    @AllArgsConstructor // Конструктор со всеми полями
    @Builder // Реализует паттерн Builder
    public class User implements UserDetails {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false, unique = true)
        private String username;

        @Column(nullable = false)
        private String password;

        @Column(nullable = false, unique = true)
        private String email;

        @Enumerated(EnumType.STRING)
        private Role role; // Роль пользователя (USER, SELLER, ADMIN)

        // Связь с анализами почвы (1 пользователь - много анализов)
        @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
        @ToString.Exclude // Исключаем из to String, чтобы избежать циклических ссылок
        @EqualsAndHashCode.Exclude // Исключаем из equals/hashCode
        private List<SoilAnalysis> soilAnalyses;

        // Связь с удобрениями (для продавцов)
//        @OneToMany(mappedBy = "seller")
//        @ToString.Exclude
//        @EqualsAndHashCode.Exclude
//        private List<Fertilizer> fertilizers;

        // Связь с отзывами
//        @OneToMany(mappedBy = "author")
//        @ToString.Exclude
//        @EqualsAndHashCode.Exclude
//        private List<Review> reviews;

        // Реализация методов UserDetails
        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return Collections.singleton(role);
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }

