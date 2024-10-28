package com.devfleming.employees.config;

import com.devfleming.employees.auditor.AuditorAwareImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Configuration class of the auditing class.
 * @author Rafael Fleming
 */
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class JpaAuditConfig {

    /**
     * Defines how it's going to instantiate the class Auditor Aware.
     * @return an AuditorAwareImpl object.
     */
    @Bean
    public AuditorAware<String> auditorAware(){
        return new AuditorAwareImpl();
    }
}
