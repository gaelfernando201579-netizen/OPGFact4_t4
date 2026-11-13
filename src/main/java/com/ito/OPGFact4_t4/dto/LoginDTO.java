package com.ito.OPGFact4_t4.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginDTO {
    @NotBlank(message = "Ingresa tu email")
    @Email(message = "Formato de email inválido")
    private String email;

    @NotBlank(message = "Ingresa tu contraseña")
    private String password;
}
