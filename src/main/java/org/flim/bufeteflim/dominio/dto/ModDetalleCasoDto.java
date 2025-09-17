package org.flim.bufeteflim.dominio.dto;

import jakarta.validation.constraints.NotBlank;

public record ModDetalleCasoDto(
        Long codeDetail,
        Long idComponent,
        Long idCase,
        String role
) {
}
