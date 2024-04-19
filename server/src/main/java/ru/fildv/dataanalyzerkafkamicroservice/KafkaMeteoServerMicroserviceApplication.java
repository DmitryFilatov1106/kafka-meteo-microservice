package ru.fildv.dataanalyzerkafkamicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaMeteoServerMicroserviceApplication {

    public static void main(final String[] args) {
        SpringApplication.run(
                KafkaMeteoServerMicroserviceApplication.class, args);
    }

}
