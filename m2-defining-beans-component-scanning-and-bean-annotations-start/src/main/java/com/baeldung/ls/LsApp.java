package com.baeldung.ls;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.baeldung.ls.persistance")
public class LsApp {

    public static void main(final String... args) {
        SpringApplication.run(LsApp.class, args);
    }

}
