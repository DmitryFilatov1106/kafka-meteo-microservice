package ru.fildv.kafkameteogeneratormicroservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.fildv.kafkameteogeneratormicroservice.model.Indicator;
import ru.fildv.kafkameteogeneratormicroservice.model.MeteoType;
import ru.fildv.kafkameteogeneratormicroservice.model.test.IndicatorTestOptions;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class TestIndicatorServiceImpl implements TestIndicatorService {
    private final ScheduledExecutorService executorService
            = Executors.newSingleThreadScheduledExecutor();
    private final KafkaIndicatorService kafkaDataService;

    @Override
    public void sendMessages(final IndicatorTestOptions testOptions) {
        if (testOptions.getMeteoTypes().length > 0) {
            executorService.scheduleAtFixedRate(
                    () -> {
                        Indicator indicator = Indicator.builder()
                                .meteoId((long) getRandomNumber(1, 5))
                                .timestamp(LocalDateTime.now())
//                        .value(getRandomNumber(1, 1))
                                .meteoType(getRandomMeasurement(
                                        testOptions.getMeteoTypes()))
                                .build();
                        if (indicator.getMeteoType() == MeteoType.TEMPERATURE) {
                            indicator.setValue(getRandomNumber(-60, 60));
                        }
                        if (indicator.getMeteoType() == MeteoType.HUMIDITY) {
                            indicator.setValue(getRandomNumber(1, 100));
                        }
                        if (indicator.getMeteoType() == MeteoType.PRESSURE) {
                            indicator.setValue(getRandomNumber(637, 812));
                        }
                        kafkaDataService.send(indicator);
                    },
                    0,
                    testOptions.getDelayInSeconds(),
                    TimeUnit.SECONDS
            );
        }
    }

    private double getRandomNumber(final int from, final int to) {
        return from + Math.random() * (to - from);
    }

    private MeteoType getRandomMeasurement(final MeteoType[] measurementTypes) {
        int randomTypeId = (int) (Math.random() * measurementTypes.length);
        return measurementTypes[randomTypeId];
    }
}
