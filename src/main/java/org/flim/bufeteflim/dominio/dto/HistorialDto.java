package org.flim.bufeteflim.dominio.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record HistorialDto(
        Long code,
        @NotBlank(message = "La descripcion es obligatoria")
        String description,
        AbogadoDto idLawyer,
        CasoDto idCase
) {
}
