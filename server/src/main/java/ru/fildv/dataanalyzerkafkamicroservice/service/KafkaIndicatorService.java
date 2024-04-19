package ru.fildv.dataanalyzerkafkamicroservice.service;

import ru.fildv.dataanalyzerkafkamicroservice.model.Indicator;

public interface KafkaIndicatorService {
    void handle(Indicator indicator);
}
