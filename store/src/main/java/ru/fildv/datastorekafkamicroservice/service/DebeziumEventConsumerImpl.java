package ru.fildv.datastorekafkamicroservice.service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.fildv.datastorekafkamicroservice.model.Indicator;
import ru.fildv.datastorekafkamicroservice.model.MeteoType;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

@Service
@RequiredArgsConstructor
public class DebeziumEventConsumerImpl implements CDCEventConsumer {
    private final SummaryService summaryService;

    @KafkaListener(topics = "indicator")
    public void handle(final String message) {
        try {
            JsonObject payload = JsonParser.parseString(message)
                    .getAsJsonObject()
                    .get("payload")
                    .getAsJsonObject();
            Indicator indicator = new Indicator();
            indicator.setId(payload.get("id").getAsLong());
            indicator.setMeteoId(payload.get("meteo_id").getAsLong());
            indicator.setValue(payload.get("value").getAsDouble());
            indicator.setMeteoType(MeteoType.valueOf(
                    payload.get("type").getAsString()));
            indicator.setTimestamp(LocalDateTime.ofInstant(
                    Instant.ofEpochMilli(
                            payload.get("timestamp").getAsLong() / 1000),
                    TimeZone.getDefault().toZoneId())
            );
            summaryService.handle(indicator);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
