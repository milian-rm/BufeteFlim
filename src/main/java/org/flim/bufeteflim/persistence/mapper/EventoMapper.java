package org.flim.bufeteflim.persistence.mapper;

import org.flim.bufeteflim.dominio.dto.*;
import org.flim.bufeteflim.persistence.entity.AbogadoEntity;
import org.flim.bufeteflim.persistence.entity.CasoEntity;
import org.flim.bufeteflim.persistence.entity.EventoEntity;
import org.flim.bufeteflim.persistence.entity.HistorialEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {CasoMapper.class, AbogadoMapper.class, HistorialMapper.class, EventTypeMapper.class})
public interface EventoMapper {

    @Mapping(source = "codigo", target = "codeEvent")
    @Mapping(source = "tipo", target = "type", qualifiedByName = "generarEventType")
    @Mapping(source = "caso", target = "casoDto")
    @Mapping(source = "abogado", target = "abogadoDto")
    @Mapping(source = "historial", target = "historialDto", qualifiedByName = "mapearHistorialSoloId")
    EventoDto toDto(EventoEntity eventoEntity);

    List<EventoDto> toDto(Iterable<EventoEntity> entities);

    @InheritInverseConfiguration
    @Mapping(source = "type", target = "tipo", qualifiedByName = "generarTipoEvento")
    @Mapping(source = "casoDto", target = "caso", qualifiedByName = "mapCasoDesdeDtoMinimo")
    @Mapping(source = "abogadoDto", target = "abogado", qualifiedByName = "mapAbogadoDesdeDtoMinimo")
    @Mapping(source = "historialDto", target = "historial", qualifiedByName = "mapHistorialDesdeDtoMinimo")
    EventoEntity toEntity(EventoDto eventoDto);

    @Mapping(source = "type", target = "tipo", qualifiedByName = "generarTipoEvento")
    @Mapping(source = "casoDto", target = "caso", qualifiedByName = "mapearCasoDto")
    @Mapping(source = "abogadoDto", target = "abogado", qualifiedByName = "mapearAbogadoDto")
    @Mapping(source = "historialDto", target = "historial", qualifiedByName = "mapHistorialDesdeDto")
    void modificarEntityFromDto(ModEventoDto modEventoDto, @MappingTarget EventoEntity entity);

    @Named("mapearHistorialSoloId")
    default HistorialDto mapearHistorialSoloId(HistorialEntity historial) {
        if (historial == null) return null;
        return new HistorialDto(
                historial.getIdHistorial(),
                historial.getDescripcion(),
                null,
                null
        );
    }

    @Named("mapHistorialDesdeDto")
    default HistorialEntity mapHistorialDesdeDto(HistorialDto dto) {
        if (dto == null || dto.code() == null) return null;
        HistorialEntity h = new HistorialEntity();
        h.setIdHistorial(dto.code());
        h.setDescripcion(dto.description());
        return h;
    }

    @Named("mapCasoDesdeDtoMinimo")
    default CasoEntity mapCasoDesdeDtoMinimo(CasoDto dto) {
        if (dto == null || dto.idCaso() == null) return null;
        CasoEntity c = new CasoEntity();
        c.setIdCaso(dto.idCaso());
        return c;
    }

    @Named("mapAbogadoDesdeDtoMinimo")
    default AbogadoEntity mapAbogadoDesdeDtoMinimo(AbogadoDto dto) {
        if (dto == null || dto.idAbogado() == null) return null;
        AbogadoEntity a = new AbogadoEntity();
        a.setIdAbogado(dto.idAbogado());
        return a;
    }

    @Named("mapHistorialDesdeDtoMinimo")
    default HistorialEntity mapHistorialDesdeDtoMinimo(HistorialDto dto) {
        if (dto == null || dto.code() == null) return null;
        HistorialEntity h = new HistorialEntity();
        h.setIdHistorial(dto.code());
        return h;
    }

}
