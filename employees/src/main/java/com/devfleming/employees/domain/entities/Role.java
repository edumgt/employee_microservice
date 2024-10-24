package com.devfleming.employees.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Role class of the employees.
 * Contains the role id, role name and if the role is active or not.
 * @author Rafael Fleming
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "EMPLOYEE_ROLE")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROLE_ID", unique = true, nullable = false)
    private Long roleId;

    @Column(name = "ROLE_NAME", unique = true, nullable = false, length = 50)
    private String roleName;

    @Column(name = "ACTIVE", nullable = false)
    private boolean active;
}
