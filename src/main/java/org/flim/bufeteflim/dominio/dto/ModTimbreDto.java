package org.flim.bufeteflim.dominio.dto;

import jakarta.validation.constraints.NotBlank;

public record ModTimbreDto(
        Long noRing,
        @NotBlank(message = "El tipo es obligatorio")
        String ringType,
        @NotBlank(message = "Elid abogado es obligatorio")
        Long idLawyer
) {
}
