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
        Employee dbEmployee = employeeRepository.getReferenceById(employee.getId());
        dbEmployee.setEntrance(employee.getEntrance());
        dbEmployee.setLastName(employee.getLastName());
        dbEmployee.setName(employee.getName());
        dbEmployee.setMiddleName(employee.getMiddleName());
        dbEmployee.setEmail(employee.getEmail());
        dbEmployee.setTelephone(employee.getTelephone());
        dbEmployee.setJobTitle(employee.getJobTitle());
        dbEmployee.setInn(employee.getInn());
        dbEmployee.setLogin(employee.getLogin());
        dbEmployee.setDescription(employee.getDescription());
        dbEmployee.setGeneralAccess(employee.getGeneralAccess());
        dbEmployee.setRoles(employee.getRoles());
        dbEmployee.setAuthor(employee.getAuthor());

        LocalDateTime localDateTime = LocalDateTime.now();
        String formattedDateTime = localDateTime.format(formatter);
        dbEmployee.setDateAndTime(formattedDateTime);
        employeeRepository.flush();
        return dbEmployee;

    }

    @Override
    public void deleteEmployee(Employee employee) {
        employeeRepository.delete(employee);

    }
}
