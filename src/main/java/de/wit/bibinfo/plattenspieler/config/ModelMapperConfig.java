package de.wit.bibinfo.plattenspieler.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper buildModelMapper() {
        return new ModelMapper();
    }

}
