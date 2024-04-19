package ru.fildv.kafkameteogeneratormicroservice.model.test;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.fildv.kafkameteogeneratormicroservice.model.MeteoType;

@NoArgsConstructor
@Getter
@Setter
public class IndicatorTestOptions {
    private int delayInSeconds;
    private MeteoType[] meteoTypes;
}
