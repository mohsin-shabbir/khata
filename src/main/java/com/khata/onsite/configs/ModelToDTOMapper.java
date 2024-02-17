package com.khata.onsite.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ModelToDTOMapper {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}