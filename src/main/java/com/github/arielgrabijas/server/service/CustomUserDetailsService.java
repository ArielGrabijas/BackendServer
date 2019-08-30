package com.github.arielgrabijas.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.github.arielgrabijas.server.model.entities.CustomUser;
import com.github.arielgrabijas.server.repository.CustomUserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private CustomUserRepository userRepository;

    @Override
    public CustomUser loadUserByUsername(String username) throws UsernameNotFoundException {
        // Used by Spring OAuth2 to load users for authentication.
        CustomUser user = userRepository.findOneByUsername(username);

        if (user != null) {

            return user;

        }

        throw new UsernameNotFoundException(username);
    }
}
