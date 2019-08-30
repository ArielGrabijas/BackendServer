package com.github.arielgrabijas.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.arielgrabijas.server.model.entities.CustomUser;

@Repository
public interface CustomUserRepository extends JpaRepository<CustomUser, Integer> {

    /**
     * Find a user by username
     *
     * @param username the user's username
     * @return user which contains the user with the given username or null.
     */
    public CustomUser findOneByUsername(String username);
}
