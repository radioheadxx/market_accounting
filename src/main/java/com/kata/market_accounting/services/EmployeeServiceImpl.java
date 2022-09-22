package com.kata.market_accounting.services;

import com.kata.market_accounting.models.Employee;
import com.kata.market_accounting.repositories.EmployeeRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public List<Employee> listEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        LocalDateTime localDateTime = LocalDateTime.now();
        String formattedDateTime = localDateTime.format(formatter);
        employee.setDateAndTime(formattedDateTime);
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        LocalDateTime localDateTime = LocalDateTime.now();
        String formattedDateTime = localDateTime.format(formatter);
        employee.setDateAndTime(formattedDateTime);
        employeeRepository.flush();
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}

