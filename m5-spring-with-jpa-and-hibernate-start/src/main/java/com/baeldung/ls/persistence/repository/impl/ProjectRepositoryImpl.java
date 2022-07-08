package com.baeldung.ls.persistence.repository.impl;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.baeldung.ls.persistence.model.Project;
import com.baeldung.ls.persistence.repository.IProjectRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
public class ProjectRepositoryImpl implements IProjectRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public Optional<Project> findById(Long id) {
        Project item = em.find(Project.class, id);
        return item != null ? Optional.of(item) : Optional.empty();
    }

    @Transactional
    @Override
    public Project save(Project project) {
        em.persist(project);
        return project;
    }

}
