package ru.fildv.kafkameteogeneratormicroservice.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import ru.fildv.kafkameteogeneratormicroservice.model.MeteoType;

import java.time.LocalDateTime;

public record IndicatorDto(Long meteoId,
                           @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
                           LocalDateTime timestamp,
                           double value,
                           MeteoType meteoType) {
}
