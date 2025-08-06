package com.pronchenko.top.soilcare.soilcare.dto;

import com.pronchenko.top.soilcare.soilcare.entity.SoilAnalysis;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SoilAnalysisDTO {
    @DecimalMin("0.0") @DecimalMax("14.0")
    private double ph;

    @PositiveOrZero
    private double nitrogen;

    @PositiveOrZero
    private double phosphorus;

    @PositiveOrZero
    private double potassium;

    @PositiveOrZero @DecimalMax("100.0")
    private double organicMatter;
    // Метод для преобразования DTO в Entity
    public SoilAnalysis toEntity() {
        return SoilAnalysis.builder()
                .ph(this.ph)
                .nitrogen(this.nitrogen)
                .phosphorus(this.phosphorus)
                .potassium(this.potassium)
                .build();
    }


}
