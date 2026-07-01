package com.ak.redrob.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

/**
 * Factory class for configuring Jackson ObjectMapper.
 */
public final class JsonMapperConfig {

    private JsonMapperConfig() {
    }

    private static final ObjectMapper OBJECT_MAPPER = createMapper();

    private static ObjectMapper createMapper() {

        ObjectMapper mapper = new ObjectMapper();

        mapper.registerModule(new JavaTimeModule());

        mapper.setPropertyNamingStrategy(
                PropertyNamingStrategies.SNAKE_CASE
        );

        mapper.findAndRegisterModules();

        return mapper;
    }

    public static ObjectMapper objectMapper() {
        return OBJECT_MAPPER;
    }

}