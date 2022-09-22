package com.kata.market_accounting.services;

import com.kata.market_accounting.models.Currency;
import com.kata.market_accounting.models.Employee;
import com.kata.market_accounting.repositories.CurrencyRepository;
import com.kata.market_accounting.repositories.EmployeeRepository;
import com.kata.market_accounting.repositories.WarehousesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {
    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    private Employee employee;

    @BeforeEach
    public void setup() {
        employeeRepository = Mockito.mock(EmployeeRepository.class);
        employeeService = new EmployeeServiceImpl(employeeRepository);
        employee = new Employee("test.cur1", "Test Currency One", "TST1");
        employee.setId(1L);
    }

    @DisplayName("JUnit test for add employee method")
    @Test
    public void givenCurrencyObject_whenSaveEmployee_thenReturnCurrencyObject() {

        given(employeeRepository.save(employee)).willReturn(employee);

        System.out.println(employeeRepository);
        System.out.println(employeeService);

        Employee savedEmployee = employeeService.createEmployee(employee);

        System.out.println(savedEmployee);

        assertThat(savedEmployee).isNotNull();
    }

    @DisplayName("JUnit test for getAll method")
    @Test
    public void givenEmployeesList_whenGetAllEmployees_thenReturnEmployeesList() {
        Employee employee1 = new Employee("test.emp2", "Test Employee Two", "TST2");

        given(employeeRepository.findAll()).willReturn(List.of(employee, employee1));

        List<Employee> employeeList = employeeService.listEmployee();

        assertThat(employeeList).isNotNull();
        assertThat(employeeList.size()).isEqualTo(2);
    }

    @DisplayName("JUnit test for getEmployee method")
    @Test
    public void givenEmployeeId_whenGetOneById_thenReturnEmployeeObject() {
        given(employeeRepository.findById(1L)).willReturn(Optional.of(employee));

        Employee savedEmployee = employeeService.getEmployee(employee.getId());

        assertThat(savedEmployee).isNotNull();
    }

    @DisplayName("JUnit test for update method")
    @Test
    public void givenEmployeeObject_whenUpdateEmployee_thenReturnUpdatedEmployee() {
        given(employeeRepository.save(employee)).willReturn(employee);
        employee.setName("updated test");

        Employee updatedEmployee = employeeService.updateEmployee(employee);

        assertThat(updatedEmployee.getName()).isEqualTo("updated test");
    }

    @DisplayName("JUnit test for delete method")
    @Test
    public void givenEmployeeId_whenDeleteEmployee_ThenNothing() {
        long employeeId = 1L;

        willDoNothing().given(employeeRepository).deleteById(employeeId);

        employeeService.deleteEmployee(employeeId);

        verify(employeeRepository, times(1)).deleteById(employeeId);
    }
}