package ru.fildv.kafkameteogeneratormicroservice.service;

import ru.fildv.kafkameteogeneratormicroservice.model.test.IndicatorTestOptions;

public interface TestIndicatorService {
    void sendMessages(IndicatorTestOptions testOptions);
}
