package com.baeldung.ls;

import com.baeldung.ls.service.IProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class LsApp {

    private static Logger logger = LoggerFactory.getLogger(LsApp.class);
    public static void main(final String... args) {

        SpringApplication.run(LsApp.class, args);

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("com.baeldung.ls.persistence.repository");
        logger.info("Context created with the id of {}", ctx.getId());
        ctx.scan("com.baeldung.ls.service");
        IProjectService projectService = ctx.getBean("projectServiceImpl", IProjectService.class);
        logger.info("{}", projectService.findById(1L));

        logger.info("Context active before close: {}", ctx.isActive());
        ctx.close();
        logger.info("Context active after close: {}", ctx.isActive());

    }

}
