package com.devfleming.employees.domain.usecases;

import com.devfleming.employees.domain.dto.EmployeeDto;
import com.devfleming.employees.domain.entities.Employee;

import java.util.List;

/**
 * Employee Service Interface, responsible to CRUD operations of the employee entity.
 * @author Rafael Fleming
 */
public interface EmployeeService {

    /**
     * Responsible to create new employee entity.
     * @param employeeDto Employee Data Transfer Object with the information of the employee that is going to be persisted.
     * @return Employee entity that was saved.
     */
    Employee createNewEmployee(EmployeeDto employeeDto);

    /**
     * Responsible to update the employee entity information.
     * @param employeeId Employee id that it's going to be updated.
     * @param employeeDto Employee Data Transfer Object that holds the new information of the saved employee.
     * @return Employee entity with the new information.
     */
    Employee updateEmployee(Long employeeId, EmployeeDto employeeDto);

    /**
     * Responsible to fetch a single employee with its ID.
     * @param employeeId Employee id that it's going to be fetched.
     * @return Fetched employee entity.
     */
    Employee fetchEmployeeById(Long employeeId);

    /**
     * Responsible to fetch a single employee with its email.
     * @param employeeEmail Employee email that it's going to be fetched.
     * @return Fetched employee entity.
     */
    Employee fetchEmployeeByEmail(String employeeEmail);

    /**
     * Responsible to fetch a single employee with its cellphone.
     * @param employeeCellphone Employee cellphone that it's going to be fetched.
     * @return Fetched employee entity.
     */
    Employee fetchEmployeeByCellphone(String employeeCellphone);

    /**
     * Responsible to fetch all employees saved in database.
     * @return List of the employees.
     */
    List<Employee> fetchEmployeesList();

    /**
     * Responsible to inactivate an employee account.
     * @param employeeId Employee ID that's going to be inactivated.
     */
    void inactivateEmployee(Long employeeId);
}
