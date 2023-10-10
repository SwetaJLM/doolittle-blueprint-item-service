package com.wn.doolittle.content.blueprintitem.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "userAuditProvider")
public class BluePrintItemContentService {

    public static void main(String[] args) {
        SpringApplication.run(BluePrintItemContentService.class, args);
    }

}
