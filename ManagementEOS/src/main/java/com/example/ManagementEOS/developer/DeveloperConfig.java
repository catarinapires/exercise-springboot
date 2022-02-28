package com.example.ManagementEOS.developer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DeveloperConfig {

    @Bean
    CommandLineRunner commandLineRunner(SystemRepository repository) {
        return args -> {
            Developer me = new Developer(
                    1,
                    "Catarina",
                    "Backend developer",
                    "catarina@email.com"

            );

            Developer other = new Developer(
                    2,
                    "John",
                    "DevOps",
                    "john@gmail.com"
            );

            repository.saveAll(
                    List.of(me, other)
            );
        };
    }
}
