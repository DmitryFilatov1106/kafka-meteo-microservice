package ru.fildv.dataanalyzerkafkamicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fildv.dataanalyzerkafkamicroservice.model.Indicator;

public interface IndicatorRepository extends JpaRepository<Indicator, Long> {
}
