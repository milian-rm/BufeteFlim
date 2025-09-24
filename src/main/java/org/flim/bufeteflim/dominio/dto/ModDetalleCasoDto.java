package org.flim.bufeteflim.dominio.dto;

import jakarta.validation.constraints.NotBlank;

public record ModDetalleCasoDto(
        Long codeDetail,
        ParteDto idComponent,
        CasoDto idCase,
        String role
) {
}
