package ru.fildv.datastorekafkamicroservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.fildv.datastorekafkamicroservice.model.Indicator;
import ru.fildv.datastorekafkamicroservice.model.MeteoType;
import ru.fildv.datastorekafkamicroservice.model.Summary;
import ru.fildv.datastorekafkamicroservice.model.SummaryType;
import ru.fildv.datastorekafkamicroservice.model.exception.IndicatorNotFoundException;
import ru.fildv.datastorekafkamicroservice.repository.SummaryRepository;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class SummaryServiceImpl implements SummaryService {

    private final SummaryRepository summaryRepository;

    @Override
    public Summary get(final Long meteoId,
                       final Set<MeteoType> meteoTypes,
                       final Set<SummaryType> summaryTypes) {
        return summaryRepository.findByMeteoId(
                        meteoId,
                        meteoTypes == null ? Set.of(MeteoType.values())
                                : meteoTypes,
                        summaryTypes == null ? Set.of(SummaryType.values())
                                : summaryTypes
                )
                .orElseThrow(IndicatorNotFoundException::new);
    }

    @Override
    public void handle(final Indicator indicator) {
        summaryRepository.handle(indicator);
    }
}
