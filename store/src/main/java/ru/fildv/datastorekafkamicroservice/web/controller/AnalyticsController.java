package ru.fildv.datastorekafkamicroservice.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.fildv.datastorekafkamicroservice.model.MeteoType;
import ru.fildv.datastorekafkamicroservice.model.Summary;
import ru.fildv.datastorekafkamicroservice.model.SummaryType;
import ru.fildv.datastorekafkamicroservice.service.SummaryService;
import ru.fildv.datastorekafkamicroservice.web.dto.SummaryDto;
import ru.fildv.datastorekafkamicroservice.web.mapper.SummaryMapper;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/analytics")
@RequiredArgsConstructor
public class AnalyticsController {
    private final SummaryService summaryService;
    private final SummaryMapper summaryMapper;

    @GetMapping("/summary/{meteoId}")
    public SummaryDto getSummary(final @PathVariable
                                 long meteoId,

                                 final @RequestParam(value = "mt",
                                         required = false)
                                 Set<MeteoType> meteoTypes,

                                 final @RequestParam(value = "st",
                                         required = false)
                                 Set<SummaryType> summaryTypes) {
        System.out.println(meteoId);
        Summary summary = summaryService.get(meteoId, meteoTypes, summaryTypes);
        return summaryMapper.toDto(summary);
    }
}
