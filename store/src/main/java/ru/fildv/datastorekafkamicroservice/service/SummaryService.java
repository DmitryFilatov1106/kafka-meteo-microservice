package ru.fildv.datastorekafkamicroservice.service;

import ru.fildv.datastorekafkamicroservice.model.Indicator;
import ru.fildv.datastorekafkamicroservice.model.MeteoType;
import ru.fildv.datastorekafkamicroservice.model.Summary;
import ru.fildv.datastorekafkamicroservice.model.SummaryType;

import java.util.Set;

public interface SummaryService {
    Summary get(Long meteoId,
                Set<MeteoType> meteoTypes,
                Set<SummaryType> summaryTypes);

    void handle(Indicator indicator);
}
