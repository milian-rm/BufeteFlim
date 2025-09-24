package org.flim.bufeteflim.dominio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.flim.bufeteflim.dominio.Specialty;

public record VerAbogadoDto(
        Long idAbogado,
        String name,
        String lastName
) {
}
