package org.flim.bufeteflim.dominio.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginRequestDto(
        @NotBlank(message = "El correo es obligatorio")
        String email,
        @NotBlank(message = "La contrasena es obligatoria")
        String password
) {}