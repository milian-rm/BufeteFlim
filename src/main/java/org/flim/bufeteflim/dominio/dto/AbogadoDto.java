package org.flim.bufeteflim.dominio.dto;

import jakarta.validation.constraints.NotNull;
import org.flim.bufeteflim.dominio.Specialty;

import jakarta.validation.constraints.NotBlank;

public record AbogadoDto(
        Long idAbogado,
        @NotBlank(message = "El nombre es obligatorio")
        String name,
        @NotBlank(message = "El apellido es obligatorio")
        String lastName,
        @NotBlank(message = "El DPI es obligatorio")
        String dpi1,
        @NotBlank(message = "El número de colegiado activo es obligatorio")
        String numActiveCollegiate,
        @NotBlank(message = "El correo es obligatorio")
        String email,
        @NotBlank(message = "El telefono es obligatorio")
        String phone,
        @NotNull(message = "La especialidad es obligatoria")
        Specialty specialty
) {
    
}
