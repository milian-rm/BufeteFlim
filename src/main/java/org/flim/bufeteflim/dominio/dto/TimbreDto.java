package org.flim.bufeteflim.dominio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TimbreDto(
        Long noRing,
        @NotBlank(message = "El tipo de Timbre es obligatorio.")
        String ringType,
        @NotNull(message = "El Abogado es obligatorio")
        AbogadoDto abogadoDto
) {
}
