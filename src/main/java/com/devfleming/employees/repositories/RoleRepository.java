package com.devfleming.employees.repositories;

import com.devfleming.employees.domain.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Role repository responsible to persist, merge and fetch information related to the employee role entity.
 * @author Rafael Fleming
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

    /**
     * Responsible to fetch role saved in database by name.
     * @param roleName The name of the role that it's going to be searched.
     * @return Saved role object.
     */
    Optional<Role> fetchByRoleName(String roleName);
}
