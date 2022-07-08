package com.baeldung.ls.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.baeldung.ls.persistence.model.Task;

public interface ITaskRepository extends CrudRepository<Task, Long> {

    @Query("SELECT t FROM Task t WHERE t.name LIKE %?1%")
    List<Task> findByNameMatches(String name);
}
