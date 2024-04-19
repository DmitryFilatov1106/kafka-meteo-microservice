package ru.fildv.datastorekafkamicroservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Indicator {
    private Long id;
    private Long meteoId;    // meteo appliance
    private LocalDateTime timestamp;
    private double value;
    private MeteoType meteoType;
}
