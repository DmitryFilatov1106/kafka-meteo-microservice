package ru.fildv.kafkameteogeneratormicroservice.web.dto;

import ru.fildv.kafkameteogeneratormicroservice.model.MeteoType;

public record IndicatorTestOptionsDto(int delayInSeconds,
                                      MeteoType[] meteoTypes) {
}
