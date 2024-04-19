package ru.fildv.dataanalyzerkafkamicroservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.fildv.dataanalyzerkafkamicroservice.model.Indicator;
import ru.fildv.dataanalyzerkafkamicroservice.repository.IndicatorRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaIndicatorServiceImpl implements KafkaIndicatorService {
    private final IndicatorRepository indicatorRepository;

    @Override
    public void handle(final Indicator indicator) {
        log.info("Data object {} was saved", indicator);
        indicatorRepository.save(indicator);
    }
}
