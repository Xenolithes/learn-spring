package com.baeldung.ls.events;

public class ProjectCreatedEvent {

    private Long id;

    public ProjectCreatedEvent(Long id) {
        this.id = id;
    }

    public Long getProjectId() {
        return id;
    }
}
