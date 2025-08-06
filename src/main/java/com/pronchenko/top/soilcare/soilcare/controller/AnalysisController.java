package com.pronchenko.top.soilcare.soilcare.controller;

import com.pronchenko.top.soilcare.soilcare.dto.AnalysisRequest;
import com.pronchenko.top.soilcare.soilcare.entity.SoilAnalysis;
import com.pronchenko.top.soilcare.soilcare.repository.SoilAnalysisRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/analysis")
public class AnalysisController {

    private final SoilAnalysisRepository repository;

    public AnalysisController(SoilAnalysisRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<SoilAnalysis> createAnalysis(
            @Valid @RequestBody AnalysisRequest request) {

        SoilAnalysis analysis = new SoilAnalysis();
        analysis.setPh(request.getPh());
        analysis.setNitrogen(request.getNitrogen());
        analysis.setPhosphorus(request.getPhosphorus());
        analysis.setPotassium(request.getPotassium());

        SoilAnalysis saved = repository.save(analysis);
        return ResponseEntity.ok(saved);
    }
}
