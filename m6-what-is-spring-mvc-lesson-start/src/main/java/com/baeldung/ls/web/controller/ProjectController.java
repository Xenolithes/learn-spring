package com.baeldung.ls.web.controller;

import com.baeldung.ls.persistence.model.Project;
import com.baeldung.ls.service.IProjectService;
import com.baeldung.ls.web.dto.ProjectDto;
import com.baeldung.ls.web.dto.TaskDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/projects")
public class ProjectController {

    @Autowired
    IProjectService projectService;

    @GetMapping("/{id}")
    public ProjectDto findOne(Long id){
        Project entity =  projectService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return convertToDto(entity);
    }

    @PostMapping
    public Project save(@RequestBody ProjectDto newProject){
        return projectService.save(convertToEntity(newProject));
    }

    protected ProjectDto convertToDto(Project entity) {
        ProjectDto dto = new ProjectDto(entity.getId(), entity.getName(), entity.getDateCreated());
        dto.setTasks(entity.getTasks().stream().map(TaskDto::convertTaskToDto).collect(Collectors.toSet()));
        return dto;
    }

    protected Project convertToEntity(ProjectDto dto) {
        Project project = new Project(dto.getName(), dto.getDateCreated());
        if(!StringUtils.isEmpty(dto.getId())){
            project.setId(dto.getId());
        }
        return project;
    }
}
