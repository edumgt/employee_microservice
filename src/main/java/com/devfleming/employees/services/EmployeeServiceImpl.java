package com.devfleming.employees.services;

import com.devfleming.employees.domain.dto.EmployeeDto;
import com.devfleming.employees.domain.entities.Employee;
import com.devfleming.employees.domain.exceptions.EmployeeAlreadyExistsException;
import com.devfleming.employees.domain.exceptions.EmployeeNotFoundException;
import com.devfleming.employees.domain.usecases.EmployeeService;
import com.devfleming.employees.mappers.EmployeeMapper;
import com.devfleming.employees.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Employee Service class responsible to CRUD operations of the employee entity.
 * @author Rafael Fleming
 */
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private final EmployeeRepository employeeRepository;

    /**
     * Responsible to create new employee.
     * @param employeeDto Employee Data Transfer Object with the information of the employee that is going to be persisted.
     * @return Employee entity that was created.
     * @throws EmployeeAlreadyExistsException If the employee that it's going to be created has the same e-mail or cellphone of an existing employee.
     */
    @Override
    @CachePut(value = "createNewEmployeeCache", key = "#employeeDto.email")
    public Employee createNewEmployee(EmployeeDto employeeDto) {

        Optional<Employee> employeeByEmail = employeeRepository.fetchEmployeeByEmail(employeeDto.getEmail());

        if(employeeByEmail.isPresent()) throw new EmployeeAlreadyExistsException("The given e-mail is already in use");

        Optional<Employee> employeeByCellphone = employeeRepository.fetchEmployeeByCellphone(employeeDto.getCellphoneNumber());

        if(employeeByCellphone.isPresent()) throw new EmployeeAlreadyExistsException("The given cellphone is already in use");

        employeeDto.setActive('A');

        return employeeRepository.save(EmployeeMapper.mapToEmployee(employeeDto));
    }

    /**
     * Responsible to update an existing employee.
     * @param employeeId Employee id that it's going to be updated.
     * @param employeeDto Employee Data Transfer Object that holds the new information of the saved employee.
     * @return Updated employee entity.
     * @throws EmployeeNotFoundException If the employee doesn't exist.
     * @throws RuntimeException If the employee is inactivated.
     */
    @Override
    @CachePut(value = "updateEmployeeCache", key = "#employeeId")
    public Employee updateEmployee(Long employeeId, EmployeeDto employeeDto) {

        Employee savedEmployee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException("Did not found the employee by id: " + employeeId));

        if(savedEmployee.getActive().equals('I')) throw new RuntimeException("This employee is inactivated.");

        savedEmployee.setFirstName(employeeDto.getFirstName());
        savedEmployee.setLastName(employeeDto.getLastName());
        savedEmployee.setCpf(employeeDto.getCpf());
        savedEmployee.setRg(employeeDto.getRg());
        savedEmployee.setRoleId(employeeDto.getRole());
        savedEmployee.setEmail(employeeDto.getEmail());
        savedEmployee.setAreaCode(employeeDto.getAreaCode());
        savedEmployee.setCellphoneNumber(employeeDto.getCellphoneNumber());

        return employeeRepository.save(savedEmployee);
    }

    /**
     * Responsible to fetch a single employee by its ID.
     * @param employeeId Employee id that it's going to be fetched.
     * @return Saved employee with the corresponding ID.
     * @throws EmployeeNotFoundException If the employee doesn't exist with the corresponding ID.
     */
    @Override
    @Cacheable(value = "fetchEmployeeByIdCache", key = "#employeeId")
    public Employee fetchEmployeeById(Long employeeId) {

        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException("Did not found the employee by id: " + employeeId));
    }

    /**
     * Responsible to fetch a single employee by its e-mail.
     * @param employeeEmail Employee e-mail that it's going to be fetched.
     * @return Saved employee with the corresponding e-mail.
     * @throws EmployeeNotFoundException If the employee doesn't exist with the corresponding e-mail.
     */
    @Override
    @Cacheable(value = "fetchEmployeeByEmailCache", key = "#employeeEmail")
    public Employee fetchEmployeeByEmail(String employeeEmail) {

        return employeeRepository.fetchEmployeeByEmail(employeeEmail)
                .orElseThrow(() -> new EmployeeNotFoundException("Did not found the employee by e-mail: " + employeeEmail));
    }

    /**
     * Responsible to fetch a single employee by its cellphone.
     * @param employeeCellphone Employee cellphone that it's going to be fetched.
     * @return Saved employee with the corresponding cellphone.
     * @throws EmployeeNotFoundException If the employee doesn't exist with the corresponding cellphone.
     */
    @Override
    @Cacheable(value = "fetchEmployeeByCellphoneCache", key = "#employeeCellphone")
    public Employee fetchEmployeeByCellphone(String employeeCellphone) {

        return employeeRepository.fetchEmployeeByEmail(employeeCellphone)
                .orElseThrow(() -> new EmployeeNotFoundException("Did not found the employee by cellphone: " + employeeCellphone));
    }

    /**
     * Responsible to fetch a list with all employees saved.
     * @return The list of the employees.
     * @throws EmployeeNotFoundException If there are no registered employees saved in database.
     */
    @Override
    public List<Employee> fetchEmployeesList() {

        List<Employee> employeeList = employeeRepository.findAll();

        if (employeeList.isEmpty()) throw new EmployeeNotFoundException("There are no registered employees");

        return employeeList;
    }

    /**
     * Responsible to inactivate an employee.
     * @param employeeId Employee ID that's going to be inactivated.
     * @throws EmployeeNotFoundException If the employee doesn't exist with the corresponding ID.
     * @throws RuntimeException If the employee is already inactive.
     */
    @Override
    @CacheEvict(value = "inactivateEmployeeCache", key = "#employeeId")
    public void inactivateEmployee(Long employeeId) {

        Employee employeeToInactivate = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException("Did not found the employee with the id: " + employeeId));

        if (employeeToInactivate.getActive().equals('I')) throw new RuntimeException("This employee is already inactive");

        employeeToInactivate.setActive('I');

        employeeRepository.save(employeeToInactivate);
    }
}
