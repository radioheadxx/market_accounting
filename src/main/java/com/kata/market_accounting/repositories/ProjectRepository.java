package com.kata.market_accounting.repositories;

import com.kata.market_accounting.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}