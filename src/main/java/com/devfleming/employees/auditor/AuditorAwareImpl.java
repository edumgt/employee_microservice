package com.devfleming.employees.auditor;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Auditing class, responsible for identifies the current user who is creating/updating an entity.
 * For now, it identifies "ADMIN" who is creating and updating the entity. Later, it will identify the current user
 * that is logged.
 */
@Component
public class AuditorAwareImpl implements AuditorAware<String> {

    /**
     * Responsible for get the current user and assign it to the creation/update of the entity.
     * @return the auditor "ADMIN".
     */
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("ADMIN");
    }
}
