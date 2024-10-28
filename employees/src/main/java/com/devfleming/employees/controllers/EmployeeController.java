package com.devfleming.employees.controllers;

import com.devfleming.employees.domain.dto.EmployeeDto;
import com.devfleming.employees.domain.dto.ResponseDto;
import com.devfleming.employees.domain.entities.Employee;
import com.devfleming.employees.domain.usecases.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.devfleming.employees.constants.EmployeeConstants.*;

/**
 * Employee Controller, responsible for expose endpoints to the outside and manage CRUD operations related to employee's entity.
 * This controller handle HTTP requests to create, read, update and inactivate the employee entity.
 * @author Rafael Fleming
 */
@RestController(value = "/api/v1")
@RequiredArgsConstructor
@ControllerAdvice
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping("/employee/create-employee")
    public ResponseEntity<ResponseDto> createNewEmployee(EmployeeDto employeeDto){
        employeeService.createNewEmployee(employeeDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(STATUS_201, MESSAGE_201));
    }

    @PutMapping("/employee/profile/{employeeId}")
    public ResponseEntity<ResponseDto> updateEmployee(@PathVariable Long employeeId, @RequestBody EmployeeDto employeeDto){
        employeeService.updateEmployee(employeeId, employeeDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(STATUS_200, MESSAGE_200));
    }

    @GetMapping("/employee")
    public ResponseEntity<Employee> fetchEmployeeById(@RequestBody Long employeeId){
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(employeeService.fetchEmployeeById(employeeId));
    }

    @GetMapping("/employee")
    public ResponseEntity<Employee> fetchEmployeeByEmail(@RequestBody String email){
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(employeeService.fetchEmployeeByEmail(email));
    }

    @GetMapping("/employee")
    public ResponseEntity<Employee> fetchEmployeeByCellphone(@RequestBody String cellphone){
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(employeeService.fetchEmployeeByCellphone(cellphone));
    }

    @GetMapping("/employee/list")
    public ResponseEntity<List<Employee>> fetchEmployeesList(){
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(employeeService.fetchEmployeesList());
    }

    @PostMapping("/employee/inactivate")
    public ResponseEntity<ResponseDto> inactivateEmployee(@RequestBody Long employeeId){
        employeeService.inactivateEmployee(employeeId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(STATUS_200,MESSAGE_200));
    }
}
