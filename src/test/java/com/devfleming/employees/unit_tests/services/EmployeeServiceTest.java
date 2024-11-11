package com.devfleming.employees.unit_tests.services;

import com.devfleming.employees.domain.dto.EmployeeDto;
import com.devfleming.employees.domain.entities.Employee;
import com.devfleming.employees.domain.exceptions.employee.EmployeeAlreadyExistsException;
import com.devfleming.employees.mappers.EmployeeMapper;
import com.devfleming.employees.repositories.EmployeeRepository;
import com.devfleming.employees.services.EmployeeServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    EmployeeRepository employeeRepository;

    @InjectMocks
    EmployeeServiceImpl employeeService;

    Employee employee;

    Employee employee2;

    EmployeeDto employeeDto;

    @BeforeEach
    void setUp() {

        employeeRepository.deleteAll();

        employee = Employee.builder()
                .firstName("John")
                .lastName("Spark")
                .cpf("123.456.789-00")
                .rg("12.345.678-9")
                .employeeEmail("john@company.com")
                .areaCode("12")
                .employeeCellphone("912345678")
                .active('A')
                .build();

        employee.setCreatedAt(LocalDateTime.now());
        employee.setCreatedBy("ADMIN");

        employeeDto = EmployeeDto.builder()
                .firstName("John")
                .lastName("Spark")
                .cpf("123.456.789-00")
                .rg("12.345.678-9")
                .email("john@company.com")
                .areaCode("12")
                .cellphoneNumber("912345678")
                .build();

        employee2 = Employee.builder()
                .firstName("Arya")
                .lastName("Spark")
                .cpf("987.654.321-00")
                .rg("98.765.432-1")
                .employeeEmail("arya@company.com")
                .areaCode("25")
                .employeeCellphone("987654321")
                .active('A')
                .build();

        employee2.setCreatedAt(LocalDateTime.now());
        employee2.setCreatedBy("ADMIN");
    }

    @Test
    @DisplayName("Employee Service Create New Employee Test")
    public void givenEmployeeObject_whenCreateNewEmployee_thenReturnSavedEmployee(){

        //given
        given(employeeRepository.fetchEmployeeByEmail(employeeDto.getEmail())).willReturn(Optional.empty());
        given(employeeRepository.fetchEmployeeByCellphone(employeeDto.getCellphoneNumber())).willReturn(Optional.empty());
        given(employeeRepository.save(employee)).willReturn(employee);

        //when
        employeeService.createNewEmployee(employeeDto);

        //then
        verify(employeeRepository, times(1)).save(employee);
    }

    @Test
    @DisplayName("Employee Service Create New Employee Email Exception Test")
    public void givenExistingEmail_whenCreateNewEmployee_thenThrowsException(){

        //given
        given(employeeRepository.fetchEmployeeByEmail(employeeDto.getEmail())).willReturn(Optional.of(employee));

        //when
        assertThrows(EmployeeAlreadyExistsException.class, () -> employeeService.createNewEmployee(employeeDto));

        //then
        verify(employeeRepository, never()).save(EmployeeMapper.mapToEmployee(employeeDto));
    }

    @Test
    @DisplayName("Employee Service Create New Employee Exception Test")
    public void givenExistingCellphone_whenCreateNewEmployee_thenThrowsException(){

        //given
        given(employeeRepository.fetchEmployeeByCellphone(employeeDto.getCellphoneNumber())).willReturn(Optional.of(employee));

        //when
        assertThrows(EmployeeAlreadyExistsException.class, () -> employeeService.createNewEmployee(employeeDto));

        //then
        verify(employeeRepository, never()).save(EmployeeMapper.mapToEmployee(employeeDto));
    }

    @Test
    @DisplayName("Employee Service Fetch Employees List Test")
    public void givenListOfEmployees_whenFetchEmployeesList_thenReturnEmployeesList(){

        //given
        given(employeeRepository.findAll()).willReturn(List.of(employee,employee2));

        //when
        List<Employee> employees = employeeService.fetchEmployeesList();

        //then
        assertThat(employees).isNotEmpty();
        assertThat(employees.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("Employee Service Fetch Employee By Id Test")
    public void givenSavedEmployee_whenFetchEmployeeById_thenReturnSavedEmployee(){

        //given
        given(employeeRepository.findById(1L)).willReturn(Optional.of(employee));

        //when
        Employee savedEmployee = employeeService.fetchEmployeeById(1L);

        //then
        assertThat(savedEmployee).isNotNull();
    }

    @Test
    @DisplayName("Employee Service Fetch Employee By Email Test")
    public void givenSavedEmployee_whenFetchEmployeeByEmail_thenReturnSavedEmployee(){

        //given
        given(employeeRepository.fetchEmployeeByEmail("john@company.com")).willReturn(Optional.of(employee));

        //when
        Employee savedEmployee = employeeService.fetchEmployeeByEmail("john@company.com");

        //then
        assertThat(savedEmployee).isNotNull();
    }

    @Test
    @DisplayName("Employee Service Fetch Employee By Cellphone Test")
    public void givenSavedEmployee_whenFetchEmployeeByCellphone_thenReturnSavedEmployee(){

        //given
        given(employeeRepository.fetchEmployeeByCellphone("912345678")).willReturn(Optional.of(employee));

        //when
        Employee savedEmployee = employeeService.fetchEmployeeByCellphone("912345678");

        //then
        assertThat(savedEmployee).isNotNull();
    }

    @Test
    @DisplayName("Employee Service Update Test")
    public void givenSavedEmployee_whenUpdateEmployee_thenReturnUpdatedEmployee(){

        //given
        given(employeeRepository.findById(1L)).willReturn(Optional.of(employee));
        given(employeeRepository.save(employee)).willReturn(employee);

        //when
        employeeService.updateEmployee(1L,employeeDto);

        //then
        verify(employeeRepository, times(1)).save(employee);
    }

    @Test
    @DisplayName("Employee Service Inactivate Employee Test")
    public void givenSavedEmployee_whenInactivateEmployee_thenReturnInactivatedEmployee(){

        //given
        given(employeeRepository.findById(1L)).willReturn(Optional.of(employee));

        //when
        employeeService.inactivateEmployee(1L);

        //then
        verify(employeeRepository, times(1)).save(employee);
    }
}
