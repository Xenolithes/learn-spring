package com.baeldung.ls.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.baeldung.ls.persistence.model.Project;
import com.baeldung.ls.persistence.repository.IProjectRepository;
import com.baeldung.ls.service.IProjectService;

import javax.annotation.Resource;

@Service
public class ProjectServiceImpl implements IProjectService {

    private IProjectRepository projectRepository;

    public static final Logger logger = LoggerFactory.getLogger(ProjectServiceImpl.class);

    @Override
    public Optional<Project> findById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }


    public IProjectRepository getProjectRepository() {
        return projectRepository;
    }

    @Resource
    public void setProjectRepository(IProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
        logger.info("Wired project repository instance: {}", projectRepository);
    }
}
