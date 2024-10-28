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
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
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
    private EmployeeRepository employeeRepository;

    @Override
    public Employee createNewEmployee(EmployeeDto employeeDto) {

        Optional<Employee> employeeByEmail = Optional.ofNullable(employeeRepository.fetchEmployeeByEmail(employeeDto.getEmail()));

        if(employeeByEmail.isPresent()) throw new EmployeeAlreadyExistsException("The given e-mail is already in use");

        Optional<Employee> employeeByCellphone = Optional.ofNullable(employeeRepository.fetchEmployeeByCellphone(employeeDto.getCellphoneNumber()));

        if(employeeByCellphone.isPresent()) throw new EmployeeAlreadyExistsException("The given cellphone is already in use");

        return employeeRepository.save(EmployeeMapper.mapToEmployee(employeeDto));
    }

    @Override
    public Employee updateEmployee(Long employeeId, EmployeeDto employeeDto) {

        Optional<Employee> savedEmployee = employeeRepository.findById(employeeId);

        if (savedEmployee.isEmpty()) throw new EmployeeNotFoundException("Did not found the employee by id: " + employeeId);

        Employee employeeToUpdate = savedEmployee.get();

        employeeToUpdate.setFirstName(employeeDto.getFirstName());
        employeeToUpdate.setLastName(employeeDto.getLastName());
        employeeToUpdate.setCpf(employeeDto.getCpf());
        employeeToUpdate.setRg(employeeDto.getRg());
        employeeToUpdate.setRoleId(employeeDto.getRoleId());
        employeeToUpdate.setEmail(employeeDto.getEmail());
        employeeToUpdate.setAreaCode(employeeDto.getAreaCode());
        employeeToUpdate.setCellphoneNumber(employeeDto.getCellphoneNumber());

        return employeeRepository.save(employeeToUpdate);
    }

    @Override
    public Employee fetchEmployeeById(Long employeeId) {

        Optional<Employee> savedEmployee = employeeRepository.findById(employeeId);

        if (savedEmployee.isEmpty()) throw new EmployeeNotFoundException("Did not found the employee with the id: " + employeeId);

        return savedEmployee.get();
    }

    @Override
    public Employee fetchEmployeeByEmail(String employeeEmail) {

        Optional<Employee> savedEmployee = Optional.ofNullable(employeeRepository.fetchEmployeeByEmail(employeeEmail));

        if (savedEmployee.isEmpty()) throw new EmployeeNotFoundException("Did not found the employee with the e-mail: " + employeeEmail);

        return savedEmployee.get();
    }

    @Override
    public Employee fetchEmployeeByCellphone(String employeeCellphone) {

        Optional<Employee> savedEmployee = Optional.ofNullable(employeeRepository.fetchEmployeeByCellphone(employeeCellphone));

        if (savedEmployee.isEmpty()) throw new EmployeeNotFoundException("Did not found the employee with the cellphone: " + employeeCellphone);

        return savedEmployee.get();
    }

    @Override
    public List<Employee> fetchEmployeesList() {

        List<Employee> employeeList = employeeRepository.findAll();

        if (employeeList.isEmpty()) throw new EmployeeNotFoundException("There are no registered employees");

        return employeeList;
    }

    @Override
    public void inactivateEmployee(Long employeeId) {

        Optional<Employee> savedEmployee = employeeRepository.findById(employeeId);

        if (savedEmployee.isEmpty()) throw new EmployeeNotFoundException("Did not found the employee with the id: " + employeeId);

        Employee employeeToInactivate = savedEmployee.get();

        employeeToInactivate.setActive('I');

        employeeRepository.save(employeeToInactivate);
    }
}
