package com.example.pos.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.modelmapper.ModelMapper;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.example.pos")
public class WebAppConfig {

    @Bean
    public ModelMapper modelMapper(){
         return new ModelMapper();
    }

}
