package com.avisys.autoconfigure;

import com.avisys.DateFormatProperties;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.time.format.DateTimeFormatter;

@AutoConfiguration
@EnableConfigurationProperties(DateFormatProperties.class)
public class DateFormatAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(name = "commonDateFormatCustomizer")
    public Jackson2ObjectMapperBuilderCustomizer commonDateFormatCustomizer(DateFormatProperties props) {
        return builder -> {
            builder.simpleDateFormat(props.getLocalDateTime());
            builder.serializers(
                    new LocalDateSerializer(DateTimeFormatter.ofPattern(props.getLocalDate())),
                    new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(props.getLocalDateTime()))
            );
            builder.featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        };
    }
}
