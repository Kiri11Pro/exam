package com.pronchenko.top.soilcare.soilcare.controller;


import com.pronchenko.top.soilcare.soilcare.dto.SoilAnalysisDTO;
import com.pronchenko.top.soilcare.soilcare.entity.SoilAnalysis;

import com.pronchenko.top.soilcare.soilcare.service.SoilAnalysisService;

import jakarta.validation.Valid;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController


@Slf4j
@Controller
@RequestMapping("/")
public class SoilAnalysisController {

    private final SoilAnalysisService soilAnalysisService;
    public SoilAnalysisController(SoilAnalysisService soilAnalysisService) {
        this.soilAnalysisService = soilAnalysisService;
    }

    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("soilAnalysisDto", new SoilAnalysisDTO());
        return "index"; // имя вашего Thymeleaf шаблона (index.html)
    }

    @PostMapping("/api/analysis")
    public String processAnalysis(@Valid @ModelAttribute("soilAnalysisDto") SoilAnalysisDTO dto,
                                  BindingResult result,
                                  RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return "/index"; // остаемся на странице с ошибками
        }

        SoilAnalysis analysis = soilAnalysisService.saveAnalysis(dto);
        redirectAttributes.addFlashAttribute("successMessage", "Анализ успешно сохранен!");
        return "redirect:/results?analysisId=" + analysis.getId();
    }
}

