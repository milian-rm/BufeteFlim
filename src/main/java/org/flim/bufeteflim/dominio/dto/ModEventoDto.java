package org.flim.bufeteflim.dominio.dto;

public record ModEventoDto(
        Long codeEvent,
        String type,
        Long idCase,
        Long idLawyer,
        Long idHistory
) {
}
