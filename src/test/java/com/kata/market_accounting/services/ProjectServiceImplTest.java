package com.kata.market_accounting.services;

import com.kata.market_accounting.models.Project;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@ExtendWith(MockitoExtension.class)
@SpringBootTest
class ProjectServiceImplTest {

    @Autowired
    private ProjectServiceImpl projectService;


    @Test
    void save() {
        Project savedProject = projectService.save(new Project(1L, "KATA", 14L,"Projects",true));
        assertThat(savedProject.getId()).isGreaterThan(0);
        System.out.println(savedProject);
    }

    @Test
    void getCurrencies() {
        List<Project> projects = projectService.getProjects();
        assertThat(projects).size().isGreaterThan(0);
    }

    @Test
    void update() {
        Project project = new Project(2L, "KATA", 15L,"Projects",true);
        project.setCode(24L);
        projectService.save(project);
        projectService.update(1, project);

        assertThat(project.getCode()).isEqualTo(24L);
        System.out.println(project);

    }

    @Test
    void delete() {
        Project project = new Project(2L, "KATA", 15L,"Projects",true);
        projectService.save(project);
        projectService.delete(2L);
        Project deletedProject = projectService.getProject(2L);
        assertThat(deletedProject).isNull();
    }
}