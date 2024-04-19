package ru.fildv.kafkameteogeneratormicroservice.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.fildv.kafkameteogeneratormicroservice.model.Indicator;
import ru.fildv.kafkameteogeneratormicroservice.model.test.IndicatorTestOptions;
import ru.fildv.kafkameteogeneratormicroservice.service.KafkaIndicatorService;
import ru.fildv.kafkameteogeneratormicroservice.service.TestIndicatorService;
import ru.fildv.kafkameteogeneratormicroservice.web.dto.IndicatorDto;
import ru.fildv.kafkameteogeneratormicroservice.web.dto.IndicatorTestOptionsDto;
import ru.fildv.kafkameteogeneratormicroservice.web.mapper.IndicatorMapper;
import ru.fildv.kafkameteogeneratormicroservice.web.mapper.IndicatorTestOptionsMapper;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api/v1/indicator")
public class IndicatorController {
    private final KafkaIndicatorService kafkaIndicatorService;
    private final TestIndicatorService testIndicatorService;

    private final IndicatorMapper indicatorMapper;
    private final IndicatorTestOptionsMapper indicatorTestOptionsMapper;

    @PostMapping("/send")
    public void send(final @RequestBody IndicatorDto indicatorDto) {
        Indicator indicator = indicatorMapper.toEntity(indicatorDto);
        log.info("Was get {}", indicator);
        kafkaIndicatorService.send(indicator);
    }

    @PostMapping("/test/send")
    public void testSend(final @RequestBody
                         IndicatorTestOptionsDto testOptionsDto) {
        IndicatorTestOptions testOptions
                = indicatorTestOptionsMapper.toEntity(testOptionsDto);
        testIndicatorService.sendMessages(testOptions);
    }
}
