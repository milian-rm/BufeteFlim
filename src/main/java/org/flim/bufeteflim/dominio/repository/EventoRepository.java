package org.flim.bufeteflim.dominio.repository;

import org.flim.bufeteflim.dominio.dto.EventoDto;
import org.flim.bufeteflim.dominio.dto.ModEventoDto;

import java.util.List;

public interface EventoRepository {
    List<EventoDto> obtenertodo();
    EventoDto buscarPorCodigo(Long id);
    EventoDto guardarEvento(EventoDto eventoDto);
    EventoDto modificarEvento(Long id, ModEventoDto modEventoDto);
    void eliminarEvento(Long id);
}
