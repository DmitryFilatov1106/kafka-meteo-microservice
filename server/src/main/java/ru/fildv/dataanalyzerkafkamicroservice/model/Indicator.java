package ru.fildv.dataanalyzerkafkamicroservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "indicator")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Indicator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "meteo_id")
    private Long meteoId;    // meteo appliance

    private LocalDateTime timestamp;
    private double value;

    @Column(name = "type")
    @Enumerated(value = EnumType.STRING)
    private MeteoType meteoType;
}
