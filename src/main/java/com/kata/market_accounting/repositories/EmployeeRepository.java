package com.kata.market_accounting.repositories;

import com.kata.market_accounting.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
