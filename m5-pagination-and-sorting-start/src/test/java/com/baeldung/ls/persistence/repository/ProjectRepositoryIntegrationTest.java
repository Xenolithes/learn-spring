package com.baeldung.ls.persistence.repository;

import com.baeldung.ls.persistence.model.Project;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.*;

@SpringBootTest
public class ProjectRepositoryIntegrationTest {

    @Autowired
    IProjectRepository projectRepository;

    @Test
    public void givenDataCreated_whenFindAllPaginated_thenSuccess() {
        Page<Project> retrievedProjects = projectRepository.findAll(PageRequest.of(0,2));
        assertEquals(retrievedProjects.getContent().size(), 2);
    }

    @Test
    public void givenDataCreated_whenFindAllPaginatedAndPageTwo_thenSuccess(){
        Page<Project> retrievedProjects = projectRepository.findAll(PageRequest.of(1, 2));
        assertThat(retrievedProjects.getContent(), hasSize(2));
    }

    @Test
    public void givenDataCreated_whenFindAllSorted_thenSuccess() {
        List<Project> retrievedProject = (List<Project>) projectRepository.findAll(Sort.by(Sort.Order.asc("name")));
        List<Project> sortedProjects = new ArrayList<>(retrievedProject);
        sortedProjects.sort(Comparator.comparing(Project::getName));

        assertEquals(sortedProjects, retrievedProject);
    }

    @Test
    public void givenDataCreated_whenFindAllPaginatedAndSorted_thenSuccess() {
        Page<Project> retrievedProjects = projectRepository.findAll(PageRequest.of(0, 2, Sort.by(Sort.Order.asc("name"))));
        assertThat(retrievedProjects.getContent(), hasSize(2));
    }

}