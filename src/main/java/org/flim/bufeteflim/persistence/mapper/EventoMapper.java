package org.flim.bufeteflim.persistence.mapper;

import org.flim.bufeteflim.dominio.dto.EventoDto;
import org.flim.bufeteflim.dominio.dto.ModEventoDto;
import org.flim.bufeteflim.persistence.entity.EventoEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = {EventTypeMapper.class})
public interface EventoMapper {

    @Mapping(source = "codigo", target = "codeEvent")
    @Mapping(source = "tipo", target = "type")
    @Mapping(source = "idCaso", target = "idCase")
    @Mapping(source = "idAbogado", target = "idLawyer")
    @Mapping(source = "idHistorial", target = "idHistory")
    EventoDto toDto(EventoEntity eventoEntity);

    List<EventoDto> toDto(Iterable<EventoEntity> entities);

    @InheritInverseConfiguration
    @Mapping(source = "type", target = "tipo", qualifiedByName = "generarTipoEvento")
    EventoEntity toEntity(EventoDto eventoDto);

    @Mapping(source = "type", target = "tipo")
    @Mapping(source = "idCase", target = "idCaso")
    @Mapping(source = "idLawyer", target = "idAbogado")
    @Mapping(source = "idHistory", target = "idHistorial")
    void modificarEntityFromDto(ModEventoDto modEventoDto, @MappingTarget EventoEntity entity);
}
