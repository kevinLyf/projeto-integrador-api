package com.senai.integrador.user.repositories;

import com.senai.integrador.user.entities.User;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, UUID> {
    UserDetails findByLogin(String login);
}
