package org.flim.bufeteflim.dominio.dto;

import jakarta.validation.constraints.NotBlank;

public record ModDetalleCasoDto(
        Long codeDetail,
        @NotBlank(message = "El id de la Parte es obligatorio")
        Long idComponent,
        @NotBlank(message = "El id del Caso es obligatorio")
        Long idCase,
        @NotBlank(message = "El rol de la Parte en el Caso es obligatorio")
        String role
) {
}
