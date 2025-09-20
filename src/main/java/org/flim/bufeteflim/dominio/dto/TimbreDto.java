package org.flim.bufeteflim.dominio.dto;

import jakarta.validation.constraints.NotBlank;

public record TimbreDto(
        Long noRing,
        @NotBlank(message = "El tipo de Timbre es obligatorio.")
        String ringType,
        @NotBlank(message = "El id del Abogado  es obligatorio")
        Long idAbogado
) {
}
