package org.flim.bufeteflim.dominio.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record HistorialDto(
        Long idHistorial,
        @NotBlank(message = "La descripcion es obligatoria")
        String description,
        @NotBlank(message = "El id abogado es obligatorio")
        Long idLawyer,
        @NotBlank(message = "El id caso es obligatorio")
        Long idCase
) {
}
