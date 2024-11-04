package com.devfleming.employees.domain.usecases;

import com.devfleming.employees.domain.entities.Role;

import java.util.List;

/**
 * Role Service Interface, responsible to CRUD operations of the role entity.
 * @author Rafael Fleming
 */
public interface RoleService {

    /**
     * Responsible to create new role for employee entity.
     * @param roleName The name of the role.
     * @return The role name with its ID and active information.
     */
    Role createNewRole(String roleName);

    /**
     * Responsible to update saved role.
     * @param roleId The ID of the role.
     * @param roleNewName The new name of the role.
     * @return The role name with the new information of the role.
     */
    Role updateRole(Long roleId, String roleNewName);

    /**
     * Responsible to fetch a single role with its ID.
     * @param roleId The ID of the role that it's going to be fetched.
     * @return Saved role object.
     */
    Role fetchRoleById(Long roleId);

    /**
     * Responsible to fetch the roles list saved in database.
     * @return A list of all roles saved.
     */
    List<Role> fetchRolesList();

    /**
     * Responsible to inactivate a single role with its ID.
     * @param roleId The ID of the role that it's going to be inactivated.
     */
    void inactivateRole(Long roleId);
}
