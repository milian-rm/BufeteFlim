package org.flim.bufeteflim.dominio.dto;

public record ModEventoDto(
        Long codeEvent,
        String type,
        CasoDto casoDto,
        AbogadoDto abogadoDto,
        HistorialDto historialDto
) {
}
