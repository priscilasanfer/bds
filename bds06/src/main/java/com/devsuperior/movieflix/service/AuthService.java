package com.devsuperior.movieflix.service;

import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repository.UserRepository;
import com.devsuperior.movieflix.service.exception.ForbiddenException;
import com.devsuperior.movieflix.service.exception.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {
    @Autowired
    private UserRepository repositoy;

    @Transactional(readOnly = true)
    public User authenticaded() {
        try {
            String userName = SecurityContextHolder.getContext().getAuthentication().getName();
            return repositoy.findByEmail(userName);
        } catch (Exception e) {
            throw new UnauthorizedException("Invalid user");
        }
    }

    public void validateUserOrAdmin(Long userId) {
        User user = authenticaded();

        if(!user.getId().equals(userId) && !user.hasRole("ROLE_ADMIN")){
            throw new ForbiddenException("Access denied");
        }
    }
}
