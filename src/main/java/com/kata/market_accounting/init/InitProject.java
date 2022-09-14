package com.kata.market_accounting.init;

import com.kata.market_accounting.models.Project;
import com.kata.market_accounting.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Component
public class InitProject implements ApplicationRunner {
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
    private final ProjectRepository projectRepository;

    @Autowired
    public InitProject(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public void run(ApplicationArguments args) {
        Project project = new Project();

        project.setId(1L);
        project.setName("Kata");
        project.setCode(2L);
        project.setDescription("Projects");
        project.setAccess(true);
        LocalDateTime localDateTime = LocalDateTime.now();
        String formattedDateTime = localDateTime.format(dtf);
        project.setDate(formattedDateTime);;
        projectRepository.save(project);
    }
}

