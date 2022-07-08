package com.baeldung.ls;

import com.baeldung.ls.service.IProjectService;
import com.baeldung.ls.service.ITaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class LsApp {

    private static final Logger logger = LoggerFactory.getLogger(LsApp.class);

    @Autowired
    IProjectService projectService;

    @Autowired
    ITaskService taskService;

    @PostConstruct
    public void postConstruct() {
        try{
            projectService.createProjectWithTasks();
        }catch(Exception e){
            logger.error("Error occurred in creating project with tasks", e);
        }

        logger.info("Fetching all Projects");
        projectService.findAll().forEach(p -> logger.info(p.toString()));

        logger.info("Fetching all Tasks");
        taskService.findAll().forEach(t -> logger.info(t.toString()));
    }

    public static void main(final String... args) {
        SpringApplication.run(LsApp.class, args);
    }

}
