package com.example.springelasticsearch;

import com.example.springelasticsearch.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(excludeFilters = @ComponentScan.Filter(
        type = FilterType.ASSIGNABLE_TYPE,
        classes = UserRepository.class))
@SpringBootApplication
public class SpringElasticSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringElasticSearchApplication.class, args);
    }

}
