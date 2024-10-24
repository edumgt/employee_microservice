package com.devfleming.employees.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Defines the employee entity.
 * @author Rafael Fleming
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMPLOYEE_ID", unique = true, nullable = false, updatable = false)
    private Long employeeId;

    @Column(name = "FIRST_NAME", nullable = false, length = 30)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false, length = 60)
    private String lastName;

    @Column(name = "CPF", unique = true, nullable = false, length = 11)
    private String cpf;

    @Column(name = "RG", unique = true, nullable = false, length = 9)
    private String rg;

    @Column(name = "EMPLOYEE_ROLE_ID", length = 50)
    private Role roleId;

    @Column(name = "EMPLOYEE_EMAIL", unique = true, nullable = false, length = 60)
    private String email;

    @Column(name = "AREA_CODE", nullable = false, length = 3)
    private String areaCode;

    @Column(name = "CELLPHONE_NUMBER", unique = true, nullable = false, length = 9)
    private String cellphoneNumber;

    @Column(name = "ACTIVE", nullable = false, length = 1)
    private Character active;
}
