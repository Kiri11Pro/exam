package com.pronchenko.top.soilcare.soilcare.dto;

import com.pronchenko.top.soilcare.soilcare.entity.SoilAnalysis;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class AnalysisRequest {
    @NotNull
    @Min(0)
    @Max(14)
    private Double ph;

    @NotNull
    @Positive
    private Double nitrogen;

    @NotNull
    @Positive
    private Double phosphorus;

    @NotNull
    @Positive
    private Double potassium;
    public SoilAnalysis toEntity() {
        return SoilAnalysis.builder()
                .ph(this.ph)
                .nitrogen(this.nitrogen)
                .phosphorus(this.phosphorus)
                .potassium(this.potassium)
                .build();
    }
}
