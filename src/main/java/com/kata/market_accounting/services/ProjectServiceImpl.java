package com.kata.market_accounting.services;

import com.kata.market_accounting.models.Country;
import com.kata.market_accounting.models.Project;
import com.kata.market_accounting.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ProjectServiceImpl implements ProjectService {

    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project getProject(long id) {
        Project project = null;
        Optional<Project> optional = projectRepository.findById(id);
        if (optional.isPresent()) {
            project = optional.get();
        }
        return project;
    }

    @Override
    public Project save(Project project) {
        LocalDateTime localDateTime = LocalDateTime.now();
        String formattedDateTime = localDateTime.format(dtf);
        project.setDate(formattedDateTime);

        projectRepository.save(project);
        return project;
    }

    @Override
    public void update(long id, Project project) {
        Project project1 = projectRepository.findById(id).get();
        project1.setName(project.getName());
        project1.setCode(project.getCode());
        project1.setDescription(project.getDescription());
        project1.setAccess(project.isAccess());
        project1.setDate(project.getDate());

        LocalDateTime localDateTime = LocalDateTime.now();
        String formattedDateTime = localDateTime.format(dtf);
        project1.setDate(formattedDateTime);

        projectRepository.flush();
    }

    @Override
    public void delete(long id) {
        projectRepository.deleteById(id);
    }
}

