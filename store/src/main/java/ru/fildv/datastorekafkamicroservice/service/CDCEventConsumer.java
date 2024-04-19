package ru.fildv.datastorekafkamicroservice.service;

public interface CDCEventConsumer {
    void handle(String message);
}
