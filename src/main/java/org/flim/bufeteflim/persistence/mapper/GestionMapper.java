package org.flim.bufeteflim.persistence.mapper;

import org.flim.bufeteflim.dominio.dto.*;
import org.flim.bufeteflim.persistence.entity.AbogadoEntity;
import org.flim.bufeteflim.persistence.entity.CasoEntity;
import org.flim.bufeteflim.persistence.entity.GestionEntity;
import org.flim.bufeteflim.persistence.entity.HistorialEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TypeMapper.class, Status1Mapper.class, AbogadoMapper.class, CasoMapper.class, HistorialMapper.class})
public interface GestionMapper {

    @Mapping(source =  "idGestion", target = "idManagement")
    @Mapping(source = "tipo", target = "type", qualifiedByName = "generarType")
    @Mapping(source = "descripcion", target = "description")
    @Mapping(source = "fechaCreacion", target = "creationDate")
    @Mapping(source = "fechaVencimiento", target = "expirationDate")
    @Mapping(source = "estado", target = "status1", qualifiedByName = "generarStatus1")
    @Mapping(source = "observaciones", target = "observations")
    @Mapping(source = "caso", target = "idCase")
    @Mapping(source = "abogado", target = "idLawyer")
    @Mapping(source = "historial", target = "idRecord")
    GestionDto toDto(GestionEntity entity);


    List<GestionDto> toDto(Iterable<GestionEntity> entities);

    @InheritInverseConfiguration
    @Mapping(source = "status1", target = "estado", qualifiedByName = "generarEstado1")
    @Mapping(source = "type", target = "tipo", qualifiedByName = "generarTipo")
    @Mapping(target = "abogado", expression = "java(abogadoFromDto(dto.idLawyer()))")
    @Mapping(target = "caso", expression = "java(casoFromDto(dto.idCase()))")
    @Mapping(target = "historial", expression = "java(historialFromDto(dto.idRecord()))")
    GestionEntity toEntity(GestionDto dto);


    @Mapping(source = "type", target = "tipo", qualifiedByName = "generarTipo")
    @Mapping(source = "description", target = "descripcion")
    @Mapping(source = "creationDate", target = "fechaCreacion")
    @Mapping(source = "expirationDate", target = "fechaVencimiento")
    @Mapping(source = "status1", target = "estado", qualifiedByName = "generarEstado1")
    @Mapping(source = "observations", target = "observaciones")
    @Mapping(target = "abogado", expression = "java(abogadoFromDto(mod.abogado()))")
    @Mapping(target = "caso", expression = "java(casoFromDto(mod.caso()))")
    @Mapping(target = "historial", expression = "java(historialFromDto(mod.historial()))")
    void modificarEntityFromDto(ModGestionDto mod, @MappingTarget GestionEntity entity);

    default AbogadoEntity abogadoFromDto(VerAbogadoDto dto) {
        if (dto == null || dto.idAbogado() == null) {
            return null;
        }
        AbogadoEntity abogado = new AbogadoEntity();
        abogado.setIdAbogado(dto.idAbogado());
        return abogado;
    }

    default CasoEntity casoFromDto(VerCasoDto dto) {
        if (dto == null || dto.idCaso() == null) {
            return null;
        }
        CasoEntity caso = new CasoEntity();
        caso.setIdCaso(dto.idCaso());
        return caso;
    }

    default HistorialEntity historialFromDto(VerHistorialDto dto){
        if (dto == null || dto.code() == null){
            return null;
        }
        HistorialEntity historial = new HistorialEntity();
        historial.setIdHistorial(dto.code());
        return historial;
    }

}
