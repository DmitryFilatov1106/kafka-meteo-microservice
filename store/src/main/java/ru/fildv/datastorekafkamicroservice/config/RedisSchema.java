package ru.fildv.datastorekafkamicroservice.config;

import lombok.experimental.UtilityClass;
import ru.fildv.datastorekafkamicroservice.model.MeteoType;

@UtilityClass
public class RedisSchema {
    //set
    public String meteoKeys() {
        return KeyHelper.getKey("meteo");
    }

    //hash with summary types
    public String summaryKey(final long meteoId, final MeteoType meteoType) {
        return KeyHelper.getKey("meteo:" + meteoId
                + ":" + meteoType.name().toLowerCase());
    }
}
