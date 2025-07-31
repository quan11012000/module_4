package org.example.blogsp.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        String usename = SecurityContextHolder.getContext().getAuthentication().getName();
        return usename != null ? Optional.of(usename) : Optional.empty();
    }
}