package com.baeldung.ls.persistence.repository;

import java.util.Optional;

import com.baeldung.ls.persistence.model.Project;
import org.springframework.data.repository.CrudRepository;

public interface IProjectRepository extends CrudRepository<Project, Long> {

}
