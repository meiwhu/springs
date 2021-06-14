package com.example.caching_data_with_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CachingDataWithSpringApplication {


    public static void main(String[] args) {
        SpringApplication.run(CachingDataWithSpringApplication.class, args);
    }

}
