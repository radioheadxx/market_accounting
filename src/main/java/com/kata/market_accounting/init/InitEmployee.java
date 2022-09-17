package com.kata.market_accounting.init;

import com.kata.market_accounting.models.Employee;
import com.kata.market_accounting.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Component
public class InitEmployee implements ApplicationRunner {

    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
    private final EmployeeRepository employeeRepository;

    @Autowired
    public InitEmployee(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void run(ApplicationArguments args) {
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setEntrance(true);
        employee.setLastName("Black");
        employee.setName("Alex");
        employee.setMiddleName("Viktorovich");
        employee.setEmail("test@test.org");
        employee.setTelephone("8-908-08-08-808");
        employee.setJobTitle("Worker");
        employee.setInn("1111111111");
        employee.setLogin("Steri");
        employee.setDescription("kak to tak");
        employee.setGeneralAccess("Yes");
        employee.setAuthor("I");

        LocalDateTime localDateTime = LocalDateTime.now();
        String formattedDateTime = localDateTime.format(dtf);
        employee.setDateAndTime(formattedDateTime);;
        employeeRepository.save(employee);
    }
}
