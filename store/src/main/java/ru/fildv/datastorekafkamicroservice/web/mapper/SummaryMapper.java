package ru.fildv.datastorekafkamicroservice.web.mapper;

import org.mapstruct.Mapper;
import ru.fildv.datastorekafkamicroservice.model.Summary;
import ru.fildv.datastorekafkamicroservice.web.dto.SummaryDto;

@Mapper(componentModel = "spring")
public interface SummaryMapper extends Mappable<Summary, SummaryDto> {
}
