package com.kata.market_accounting.mappers;

import com.kata.market_accounting.models.Project;
import com.kata.market_accounting.models.dto.ProjectDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProjectMapper {

    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);
    ProjectDTO toDTO (Project project);
}
