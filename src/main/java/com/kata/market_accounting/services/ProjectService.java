package com.kata.market_accounting.services;

import com.kata.market_accounting.models.Project;

import java.util.List;

public interface ProjectService {

    List<Project> findAll();

    void save(Project project);

    void delete(Project project);

    void update(long id, Project project);

}
