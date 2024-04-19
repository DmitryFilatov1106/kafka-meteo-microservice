package ru.fildv.kafkameteogeneratormicroservice.web.mapper;

import org.mapstruct.Mapper;
import ru.fildv.kafkameteogeneratormicroservice.model.Indicator;
import ru.fildv.kafkameteogeneratormicroservice.web.dto.IndicatorDto;

@Mapper(componentModel = "spring")
public interface IndicatorMapper extends Mappable<Indicator, IndicatorDto> {
}
