package com.kata.market_accounting.services;

import com.kata.market_accounting.models.Country;
import com.kata.market_accounting.models.Project;

import java.util.List;

public interface ProjectService {

    List<Project> getProjects();

    Project save(Project project);

    void delete(long id);

    void update(long id, Project project);

    Project getProject(long id);


}
