package com.devfleming.employees.repositories;

import com.devfleming.employees.domain.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Employee Repository responsible to persist, merge and fetch information related to the employee entity.
 * @author Rafael Fleming
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    /**
     * Responsible to fetch a single employee with its email from the database.
     * @param employeeEmail Employee email that it's going to be fetched.
     * @return Fetched employee entity.
     */
    @Query(value = "select * from employee e where e.employee_email = ?1", nativeQuery = true)
    Optional<Employee> fetchEmployeeByEmail(String employeeEmail);

    /**
     * Responsible to fetch a single employee with its cellphone from the database.
     * @param employeeCellphone Employee cellphone that it's going to be fetched.
     * @return Fetched employee entity.
     */
    @Query(value = "select * from employee e where e.cellphone_number = ?1", nativeQuery = true)
    Optional<Employee> fetchEmployeeByCellphone(String employeeCellphone);
}
