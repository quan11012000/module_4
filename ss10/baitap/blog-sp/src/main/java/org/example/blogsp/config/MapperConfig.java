package org.example.blogsp.config;

import org.example.blogsp.dto.BlogDto;
import org.example.blogsp.entity.Blog;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.typeMap(Blog.class, BlogDto.class).addMapping(
                src -> src.getCategory().getNameType(),
                BlogDto::setCategoryName
        );
        return mapper;
    }
}
