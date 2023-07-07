package com.senai.integrador.auth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.integrador.user.entities.User;
import com.senai.integrador.user.repositories.UserRepository;
import com.senai.integrador.auth.dtos.AutheticationRecordDto;
import com.senai.integrador.auth.dtos.RegisterRecordDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository UserRepository;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AutheticationRecordDto data) {
        UsernamePasswordAuthenticationToken userNamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(userNamePassword);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterRecordDto data) {
        if (this.UserRepository.findByLogin(data.login()) != null)
            return ResponseEntity.badRequest().build();

        String encryptPassword = new BCryptPasswordEncoder().encode(data.password());
        User user = new User(data.login(), encryptPassword, data.role());

        this.UserRepository.save(user);

        return ResponseEntity.ok().build();
    }

}
