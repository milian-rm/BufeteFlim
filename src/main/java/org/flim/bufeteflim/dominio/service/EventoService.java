package org.flim.bufeteflim.dominio.service;

import org.flim.bufeteflim.dominio.dto.EventoDto;
import org.flim.bufeteflim.dominio.dto.ModEventoDto;
import org.flim.bufeteflim.dominio.repository.EventoRepository;

import java.util.List;

public class EventoService {

    private final EventoRepository eventoRepository;

    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public List<EventoDto> obtenerTodo() {
        return this.eventoRepository.obtenertodo();
    }

    public EventoDto buscarPorCodigo(Long id){
        return this.eventoRepository.buscarPorCodigo(id);
    }

    public EventoDto guardarEvento(EventoDto eventoDto) {
        return this.eventoRepository.guardarEvento(eventoDto);
    }

    public EventoDto modificarEvento(Long id, ModEventoDto modEventoDto) {
        return this.eventoRepository.modificarEvento(id, modEventoDto);
    }

    public void eliminarEvento(Long id) {
        this.eventoRepository.eliminarEvento(id);
    }
}
