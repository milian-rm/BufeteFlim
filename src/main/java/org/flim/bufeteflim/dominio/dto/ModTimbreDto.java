package org.flim.bufeteflim.dominio.dto;

import jakarta.validation.constraints.NotBlank;

public record ModTimbreDto(
        @NotBlank(message = "El tipo es obligatorio")
        String ringType,
        @NotBlank(message = "Elid abogado es obligatorio")
        Long idLawyer
) {
}
