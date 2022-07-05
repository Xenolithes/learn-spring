package com.baeldung.ls.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.baeldung.ls.persistence.model.Project;
import com.baeldung.ls.persistence.repository.IProjectRepository;
import com.baeldung.ls.service.IProjectService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Service
public class ProjectServiceImpl implements IProjectService, ApplicationContextAware {

    private static final Logger logger = LoggerFactory.getLogger(ProjectServiceImpl.class);

    @Autowired
    private IProjectRepository projectRepository;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        logger.info("Context with ID '{}' SET", applicationContext.getId());
    }

    public ProjectServiceImpl(IProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Optional<Project> findById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }

    @PostConstruct
    public void created(){
        logger.info("Post Construction method within the ProjectServiceImpl");
    }

    @PreDestroy
    public void onDestroy(){
        logger.info("Pre destroy within the ProjectServiceImpl");
    }

}
