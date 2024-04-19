package ru.fildv.datastorekafkamicroservice.repository;

import ru.fildv.datastorekafkamicroservice.model.Indicator;
import ru.fildv.datastorekafkamicroservice.model.MeteoType;
import ru.fildv.datastorekafkamicroservice.model.Summary;
import ru.fildv.datastorekafkamicroservice.model.SummaryType;

import java.util.Optional;
import java.util.Set;

public interface SummaryRepository {
    Optional<Summary> findByMeteoId(long meteoId,
                                    Set<MeteoType> meteoTypes,
                                    Set<SummaryType> summaryTypes);

    void handle(Indicator indicator);
}
