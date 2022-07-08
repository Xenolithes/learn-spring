package com.baeldung.ls.persistence.repository;

import static org.apache.commons.lang3.RandomStringUtils.random;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.baeldung.ls.persistence.model.Project;

@SpringBootTest
public class ProjectRepositoryIntegrationTest {

    @Autowired
    private IProjectRepository projectRepository;

    @Test
    public void whenSavingNewProject_thenSuccess() {
        Project newProject = new Project(randomAlphabetic(6), LocalDate.now());

        assertNotNull(projectRepository.save(newProject));
    }

    @Test
    public void givenProject_whenFindById_thenSuccess() {
        Project newProject = new Project(randomAlphabetic(6), LocalDate.now());
        projectRepository.save(newProject);

        Optional<Project> retrievedProject = projectRepository.findById(newProject.getId());

        assertEquals(retrievedProject.get(), newProject);
    }

    @Test
    void givenName_whenFindByName_thenSuccess() {
        Project newProject = new Project(randomAlphabetic(6), LocalDate.now());
        projectRepository.save(newProject);
        Optional<Project> retrievedProject = projectRepository.findByName(newProject.getName());
        assertEquals(retrievedProject.get(), newProject);
    }

    @Test
    void givenDates_whenFindByDateCreatedBetween_thenSuccess() {
        Project oldProject = new Project(randomAlphabetic(6), LocalDate.now().minusYears(1));
        Project futureProject = new Project(randomAlphabetic(6), LocalDate.now().plusYears(1));
        projectRepository.save(oldProject);
        projectRepository.save(futureProject);
        List<Project> retrievedProjects = projectRepository.findByDateCreatedBetween(LocalDate.now(), LocalDate.now().plusYears(2));
        assertThat(retrievedProjects, hasItems(futureProject));
    }


}