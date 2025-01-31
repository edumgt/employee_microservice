package com.devfleming.employees.mappers;

import com.devfleming.employees.domain.dto.EmployeeDto;
import com.devfleming.employees.domain.entities.Employee;

/**
 * Employee Mapper responsible to map employee DTO to employee entity and vice versa.
 * @author Rafael Fleming
 */
public class EmployeeMapper {

    /**
     * Responsible to map Employee Data Transfer Object to Employee entity.
     * @param employeeDto Data Transfer Object of the employee.
     * @return Employee entity with the Employee DTO information.
     */
    public static Employee mapToEmployee(EmployeeDto employeeDto){

        return Employee.builder()
                .firstName(employeeDto.getFirstName())
                .lastName(employeeDto.getLastName())
                .cpf(employeeDto.getCpf())
                .rg(employeeDto.getRg())
                .employeeEmail(employeeDto.getEmail())
                .areaCode(employeeDto.getAreaCode())
                .employeeCellphone(employeeDto.getCellphoneNumber())
                .build();
    }

    /**
     * Responsible to map Employee entity to Employee Data Transfer Object
     * @param employee Employee entity.
     * @return Employee Data Transfer Object with the Employee information.
     */
    public static EmployeeDto mapToEmployeeDto(Employee employee){

        return EmployeeDto.builder()
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .cpf(employee.getCpf())
                .rg(employee.getRg())
                .email(employee.getEmployeeEmail())
                .areaCode(employee.getAreaCode())
                .cellphoneNumber(employee.getEmployeeCellphone())
                .build();
    }
}
