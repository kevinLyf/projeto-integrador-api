package com.senai.integrador.auth.dtos;

import jakarta.validation.constraints.NotBlank;

public record AutheticationRecordDto(@NotBlank String login, @NotBlank String password) {}
