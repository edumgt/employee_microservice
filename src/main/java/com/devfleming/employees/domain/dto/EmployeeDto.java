package com.devfleming.employees.domain.dto;

import com.devfleming.employees.domain.entities.Role;
import lombok.*;

/**
 * Employee Data Transfer Object for creation, updating and other process related to the employee entity.
 * @author Rafael Fleming
 */
@Getter @Setter @ToString
@Builder
@AllArgsConstructor
public class EmployeeDto {

    private String firstName;

    private String lastName;

    private String cpf;

    private String rg;

    private Role role;

    private String email;

    private String areaCode;

    private String cellphoneNumber;

    private Character active;
}
