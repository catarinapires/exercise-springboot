package com.example.ManagementEOS.developer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TicketConfig {
    private final SystemService systemService;
    @Autowired
    public TicketConfig(SystemService systemService) {
        this.systemService = systemService;
    }

    @Bean
    CommandLineRunner commandLineRunner2(TicketRepository repository) {
        return args -> {
            Ticket me = new Ticket(
                    1,
                    "Modify ticket info",
                    systemService.getDevelopers().get(1),
                    false

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
