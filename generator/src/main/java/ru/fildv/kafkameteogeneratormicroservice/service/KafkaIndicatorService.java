package ru.fildv.kafkameteogeneratormicroservice.service;

import ru.fildv.kafkameteogeneratormicroservice.model.Indicator;

public interface KafkaIndicatorService {
    void send(Indicator indicator);
}
