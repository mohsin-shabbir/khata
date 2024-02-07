package com.khata.onsite.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ModleToDTOMapper {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}