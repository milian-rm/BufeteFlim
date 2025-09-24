package org.flim.bufeteflim.dominio.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;

public record HistorialDto(
        Long code,
        @NotBlank(message = "La descripcion es obligatoria")
        String description,
        VerAbogadoDto idLawyer,
        VerCasoDto idCase
) {
}
