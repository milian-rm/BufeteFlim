package org.flim.bufeteflim.dominio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ModTimbreDto(
        @NotBlank(message = "El tipo es obligatorio")
        String ringType,
        @NotNull(message = "El Abogado es obligatorio")
        AbogadoDto abogadoDto
) {
}
