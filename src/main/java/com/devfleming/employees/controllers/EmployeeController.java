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

    /**
     * Request the creation of a new employee.
     * @param employeeDto Employee DTO containing the employee information required to create a new employee.
     * @return Entity response with status "201 CREATED", and a response DTO containing the status code and a message
     * saying "Employee created successfully"
     */
    @PostMapping("/employee/create-employee")
    public ResponseEntity<ResponseDto> createNewEmployee(EmployeeDto employeeDto){
        employeeService.createNewEmployee(employeeDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(STATUS_201, MESSAGE_201));
    }

    /**
     * Request the update of a saved employee.
     * @param employeeId The ID of the employee saved in database.
     * @param employeeDto Employee DTO containing the employee information required to update employee saved.
     * @return Entity response with status "200 OK", and a response DTO containing the status code and a message
     *      * saying "Request processed successfully"
     */
    @PutMapping("/employee/profile/{employeeId}")
    public ResponseEntity<ResponseDto> updateEmployee(@PathVariable Long employeeId, @RequestBody EmployeeDto employeeDto){
        employeeService.updateEmployee(employeeId, employeeDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(STATUS_200, MESSAGE_200));
    }

    /**
     * Fetch a single employee with its ID.
     * @param employeeId The ID of the employee saved in database.
     * @return Response with the employee saved, and the Http Status 201.
     */
    @GetMapping("/employee")
    public ResponseEntity<Employee> fetchEmployeeById(@RequestBody Long employeeId){
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(employeeService.fetchEmployeeById(employeeId));
    }

    /**
     * Fetch a single employee with its email.
     * @param email The email of the employee saved in database.
     * @return Response with the employee saved, and the Http Status 201.
     */
    @GetMapping("/employee")
    public ResponseEntity<Employee> fetchEmployeeByEmail(@RequestBody String email){
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(employeeService.fetchEmployeeByEmail(email));
    }

    /**
     * Fetch a single employee with its cellphone.
     * @param cellphone The cellphone of the employee saved in database.
     * @return Response with the employee saved, and the Http Status 201.
     */
    @GetMapping("/employee")
    public ResponseEntity<Employee> fetchEmployeeByCellphone(@RequestBody String cellphone){
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(employeeService.fetchEmployeeByCellphone(cellphone));
    }

    /**
     * Fetch all employees saved in database with no filters.
     * @return List of all employees, and the Http Status 201.
     */
    @GetMapping("/employee/list")
    public ResponseEntity<List<Employee>> fetchEmployeesList(){
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(employeeService.fetchEmployeesList());
    }

    /**
     * Inactivate an employee, changing its active status.
     * @param employeeId The ID of the employee saved in database.
     * @return Response with the Http Status 200 and a 200 Message ("Request processed successfully")
     */
    @PostMapping("/employee/inactivate")
    public ResponseEntity<ResponseDto> inactivateEmployee(@RequestBody Long employeeId){
        employeeService.inactivateEmployee(employeeId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(STATUS_200,MESSAGE_200));
    }
}
