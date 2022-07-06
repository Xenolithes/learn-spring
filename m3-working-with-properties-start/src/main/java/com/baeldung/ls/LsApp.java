package com.baeldung.ls;

import javax.annotation.PostConstruct;

import com.baeldung.ls.persistence.model.Project;
import com.baeldung.ls.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.time.LocalDate;

@SpringBootApplication
public class LsApp {

    @Autowired
    IProjectService projectService;

    @Autowired
    private Environment environment;

    public static void main(final String... args) {
        SpringApplication.run(LsApp.class, args);
    }

    @PostConstruct
    public void postConstruct() {
        projectService.save(new Project(1L, "My First Project", LocalDate.now()));
    }
}
