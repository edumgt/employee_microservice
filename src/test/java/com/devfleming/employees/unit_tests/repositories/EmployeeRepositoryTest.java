package com.devfleming.employees.unit_tests.repositories;

import com.devfleming.employees.domain.entities.Employee;
import com.devfleming.employees.repositories.EmployeeRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository employeeRepository;

    Employee employee;

    Employee employee2;

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
    @Order(1)
    @DisplayName("Employee Repository Save Test")
    public void givenEmployeeObject_whenSave_thenReturnSavedEmployee(){

        //given

        //when
        Employee savedEmployee = employeeRepository.save(employee);

        //then
        assertThat(savedEmployee).isNotNull();
        assertThat(savedEmployee.getEmployeeId()).isEqualTo(1L);
        assertThat(savedEmployee.getCpf()).isEqualTo(employee.getCpf());
        assertThat(savedEmployee.getRg()).isEqualTo(employee.getRg());
        assertThat(savedEmployee.getEmployeeEmail()).isEqualTo(employee.getEmployeeEmail());
        assertThat(savedEmployee.getEmployeeCellphone()).isEqualTo(employee.getEmployeeCellphone());
    }

    @Test
    @Order(2)
    @DisplayName("Employee Repository Find By Id Test")
    public void givenEmployeeObject_whenFindById_thenReturnSavedEmployee(){

        //given
        employeeRepository.save(employee);

        //when
        Optional<Employee> savedEmployee = employeeRepository.findById(employee.getEmployeeId());

        //then
        assertThat(savedEmployee).isNotNull();
        assertThat(savedEmployee.get().getEmployeeId()).isEqualTo(employee.getEmployeeId());
    }

    @Test
    @Order(3)
    @DisplayName("Employee Repository Find By Email Test")
    public void givenEmployeeObject_whenFindByEmail_thenReturnSavedEmployee(){

        //given
        employeeRepository.save(employee);

        //when
        Optional<Employee> savedEmployee = employeeRepository.fetchEmployeeByEmail(employee.getEmployeeEmail());

        //then
        assertThat(savedEmployee).isNotNull();
        assertThat(savedEmployee.get().getEmployeeEmail()).isEqualTo(employee.getEmployeeEmail());
    }

    @Test
    @Order(4)
    @DisplayName("Employee Repository Find By Cellphone Test")
    public void givenEmployeeObject_whenFindByCellphone_thenReturnSavedEmployee(){

        //given
        employeeRepository.save(employee);

        //when
        Optional<Employee> savedEmployee = employeeRepository.fetchEmployeeByCellphone(employee.getEmployeeCellphone());

        //then
        assertThat(savedEmployee).isNotNull();
        assertThat(savedEmployee.get().getEmployeeCellphone()).isEqualTo(employee.getEmployeeCellphone());
    }

    @Test
    @Order(5)
    @DisplayName("Employee Repository Find All Test")
    public void givenEmployeeList_whenFindAll_thenReturnSavedEmployees(){

        //given
        employeeRepository.saveAll(List.of(employee,employee2));

        //when
        List<Employee> savedEmployees = employeeRepository.findAll();

        //then
        assertThat(savedEmployees).isNotEmpty();
        assertThat(savedEmployees.getFirst()).isEqualTo(employee);
        assertThat(savedEmployees.get(1)).isEqualTo(employee2);
    }

    @Test
    @Order(6)
    @DisplayName("Employee Repository Update Test")
    public void givenEmployeeObject_whenUpdateEmployee_thenReturnUpdatedEmployee(){

        //given
        employeeRepository.save(employee);

        //when
        Employee employeeToUpdate = employeeRepository.findById(employee.getEmployeeId()).get();
        employeeToUpdate.setFirstName("Jeffrey");
        employeeToUpdate.setLastName("Lauper");
        employeeToUpdate.setCpf("999.999.999-99");
        employeeToUpdate.setRg("11.111.111-1");
        employeeToUpdate.setEmployeeEmail("jeffrey@company.com");
        employeeToUpdate.setEmployeeCellphone("922221111");
        employeeToUpdate.setAreaCode("21");

        Employee employeeUpdated = employeeRepository.save(employeeToUpdate);

        //then
        assertThat(employeeUpdated).isNotNull();
        assertThat(employeeUpdated.getFirstName()).isNotEqualTo("John");
        assertThat(employeeUpdated.getLastName()).isNotEqualTo("Spark");
        assertThat(employeeUpdated.getCpf()).isNotEqualTo("123.456.789-00");
        assertThat(employeeUpdated.getRg()).isNotEqualTo("12.345.678-9");
        assertThat(employeeUpdated.getEmployeeEmail()).isNotEqualTo("john@company.com");
        assertThat(employeeUpdated.getEmployeeCellphone()).isNotEqualTo("912345678");
        assertThat(employeeUpdated.getAreaCode()).isNotEqualTo("12");
    }
}
