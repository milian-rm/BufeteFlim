package org.flim.bufeteflim.persistence;

import org.flim.bufeteflim.dominio.dto.EventoDto;
import org.flim.bufeteflim.dominio.dto.ModEventoDto;
import org.flim.bufeteflim.dominio.repository.EventoRepository;
import org.flim.bufeteflim.persistence.crud.CrudEventoEntity;
import org.flim.bufeteflim.persistence.entity.EventoEntity;
import org.flim.bufeteflim.persistence.mapper.EventoMapper;

import java.util.List;

public class EventoEntityRepository implements EventoRepository {

    private final CrudEventoEntity crudEventoEntity;
    private final EventoMapper eventoMapper;

    public EventoEntityRepository(CrudEventoEntity crudEventoEntity, EventoMapper eventoMapper) {
        this.crudEventoEntity = crudEventoEntity;
        this.eventoMapper = eventoMapper;
    }

    @Override
    public List<EventoDto> obtenerTodo() {
        return this.eventoMapper.toDto(this.crudEventoEntity.findAll());
    }

    @Override
    public EventoDto buscarPorCodigo(Long codeEvent) {
        return this.eventoMapper.toDto(this.crudEventoEntity.findById(codeEvent).orElse(null));
    }

    @Override
    public EventoDto guardarEvento(EventoDto eventoDto) {
        if(this.crudEventoEntity.findFirstByCodigo(eventoDto.codeEvent()) != null) {
            //throw new EventoYaExisteException(eventoDto.codeEvent());
        }

        EventoEntity evento = new EventoEntity();

        evento = this.eventoMapper.toEntity(eventoDto);

        this.crudEventoEntity.save(evento);

        return this.eventoMapper.toDto(evento);
    }

    @Override
    public EventoDto modificarEvento(Long codeEvent, ModEventoDto modEventoDto){
        EventoEntity evento = this.crudEventoEntity.findById(codeEvent).orElse(null);

        if(evento == null){
            //throw new EventoNoExisteException(codeEvent);
        }
        this.eventoMapper.modificarEntityFromDto(modEventoDto, evento);

        return this.eventoMapper.toDto(this.crudEventoEntity.save(evento));
    }

    @Override
    public void eliminarEvento(Long codeEvent) {
        EventoEntity evento = this.crudEventoEntity.findById(codeEvent).orElse(null);

        if(evento == null){
            //throw new EventoNoExisteException(codeEvent);
        }else{
            this.crudEventoEntity.deleteById(codeEvent);
        }
    }
}
