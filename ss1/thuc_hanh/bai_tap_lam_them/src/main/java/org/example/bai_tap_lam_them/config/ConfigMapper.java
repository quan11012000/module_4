package org.example.bai_tap_lam_them.config;

import org.example.bai_tap_lam_them.dto.PigDTO;
import org.example.bai_tap_lam_them.entity.Pig;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigMapper {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}