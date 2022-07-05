package com.baeldung.ls;

import com.baeldung.ls.persistence.repository.IProjectRepository;
import com.baeldung.ls.service.impl.ProjectServiceImplSetterInjection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LsAppConfig {

    @Bean
    ProjectServiceImplSetterInjection projectService () {
        return new ProjectServiceImplSetterInjection();
    }
}
