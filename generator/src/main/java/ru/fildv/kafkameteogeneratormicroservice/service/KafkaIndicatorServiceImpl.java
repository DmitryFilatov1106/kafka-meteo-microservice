package ru.fildv.kafkameteogeneratormicroservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.kafka.sender.KafkaSender;
import reactor.kafka.sender.SenderRecord;
import ru.fildv.kafkameteogeneratormicroservice.model.Indicator;

@Service
@RequiredArgsConstructor
public class KafkaIndicatorServiceImpl implements KafkaIndicatorService {
    private final KafkaSender<String, Object> sender;

    @Override
    public void send(final Indicator indicator) {
        String topic = switch (indicator.getMeteoType()) {
            case TEMPERATURE -> "indicator-temperature";
            case HUMIDITY -> "indicator-humidity";
            case PRESSURE -> "indicator-pressure";
        };
        sender.send(
                        Mono.just(
                                SenderRecord.create(
                                        topic,
                                        0,
                                        System.currentTimeMillis(),
                                        String.valueOf(indicator.hashCode()),
                                        indicator,
                                        null
                                )
                        )
                )
                .subscribe();
    }
}
