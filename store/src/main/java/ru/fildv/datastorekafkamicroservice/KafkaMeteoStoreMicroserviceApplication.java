package ru.fildv.datastorekafkamicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaMeteoStoreMicroserviceApplication {

    public static void main(final String[] args) {
        SpringApplication.run(
                KafkaMeteoStoreMicroserviceApplication.class, args);
    }

}
