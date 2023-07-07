package com.senai.integrador.auth.dtos;

import com.senai.integrador.user.enums.Role;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterRecordDto(@NotBlank String login, @NotBlank String password, @NotNull Role role) {}
