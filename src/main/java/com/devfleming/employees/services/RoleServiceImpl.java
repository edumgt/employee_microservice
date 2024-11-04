package com.devfleming.employees.services;

import com.devfleming.employees.domain.entities.Role;
import com.devfleming.employees.domain.usecases.RoleService;
import com.devfleming.employees.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    @Autowired
    private final RoleRepository roleRepository;

    @Override
    public Role createNewRole(String roleName) {

        Optional<Role> role = roleRepository.fetchByRoleName(roleName);

        if (role.isPresent()) throw new RuntimeException("This role already exists");

        Role roleToSave = Role.builder()
                .roleName(roleName)
                .active('A')
                .build();

        return roleRepository.save(roleToSave);
    }

    @Override
    public Role updateRole(Long roleId, String roleNewName) {

        Optional<Role> role = roleRepository.fetchByRoleName(roleNewName);

        if (roleNewName.isEmpty()) throw new RuntimeException("This role does not exist.");

        Optional<Role> savedRole = roleRepository.findById(roleId);

        return null;
    }

    @Override
    public Role fetchRoleById(Long roleId) {
        return null;
    }

    @Override
    public List<Role> fetchRolesList() {
        return List.of();
    }

    @Override
    public void inactivateRole(Long roleId) {

    }
}
