package org.flim.bufeteflim.dominio.dto;

import jakarta.validation.constraints.NotBlank;

public record EventoDto(
        Long codeEvent,
        @NotBlank(message = "El tipo de Evento es obligatorio")
        String type,
        CasoDto casoDto,
        AbogadoDto abogadoDto,
        HistorialDto historialDto
) {
}
