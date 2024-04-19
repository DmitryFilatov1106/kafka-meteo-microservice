package ru.fildv.kafkameteogeneratormicroservice.web.mapper;

import org.mapstruct.Mapper;
import ru.fildv.kafkameteogeneratormicroservice.model.test.IndicatorTestOptions;
import ru.fildv.kafkameteogeneratormicroservice.web.dto.IndicatorTestOptionsDto;

@Mapper(componentModel = "spring")
public interface IndicatorTestOptionsMapper
        extends Mappable<IndicatorTestOptions, IndicatorTestOptionsDto> {
}
