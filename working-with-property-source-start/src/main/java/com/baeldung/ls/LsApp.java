package com.baeldung.ls;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class LsApp {
    private static final Logger logger = LoggerFactory.getLogger(LsApp.class);

    @Value("${additional.info}")
    private String additionalInformation;

    public static void main(final String... args) {
        SpringApplication.run(LsApp.class, args);
    }

    @PostConstruct
    public void initialization(){
        logger.info("This is the info: {}", additionalInformation);
    };
}
