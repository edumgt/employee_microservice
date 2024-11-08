package com.devfleming.employees.domain.dto;

import lombok.*;

import java.util.Set;

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

    private String email;

    private String areaCode;

    private String cellphoneNumber;

    private Character active;
}
