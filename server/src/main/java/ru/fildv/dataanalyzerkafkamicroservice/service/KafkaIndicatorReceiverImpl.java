package ru.fildv.dataanalyzerkafkamicroservice.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.kafka.receiver.KafkaReceiver;
import ru.fildv.dataanalyzerkafkamicroservice.config.LocalDateTimeDeserializer;
import ru.fildv.dataanalyzerkafkamicroservice.model.Indicator;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class KafkaIndicatorReceiverImpl implements KafkaIndicatorReceiver {
    private final KafkaReceiver<String, Object> receiver;
    private final LocalDateTimeDeserializer localDateTimeDeserializer;
    private final KafkaIndicatorService kafkaIndicatorService;

    @PostConstruct
    private void init() {
        fetch();
    }

    @Override
    public void fetch() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class,
                        localDateTimeDeserializer)
                .create();
        receiver.receive()
                .subscribe(r -> {
                    Indicator data = gson
                            .fromJson(r.value().toString(), Indicator.class);
                    kafkaIndicatorService.handle(data);
                    r.receiverOffset().acknowledge();
                });
    }
}
