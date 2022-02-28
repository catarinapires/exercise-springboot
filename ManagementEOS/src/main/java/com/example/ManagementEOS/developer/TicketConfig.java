package com.example.ManagementEOS.developer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TicketConfig {
    @Bean
    CommandLineRunner commandLineRunner2(TicketRepository repository) {
        return args -> {
            Ticket me = new Ticket(
                    1,
                    "Modify ticket info"

            );

            Ticket other = new Ticket(
                    2,
                    "Modify existing developer info"
            );

            repository.saveAll(
                    List.of(me, other)
            );
        };
    }
}
