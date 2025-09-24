package org.flim.bufeteflim.persistence.mapper;

import org.flim.bufeteflim.dominio.dto.GestionDto;
import org.flim.bufeteflim.dominio.dto.ModGestionDto;
import org.flim.bufeteflim.persistence.entity.GestionEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TypeMapper.class, Status1Mapper.class})
public interface GestionMapper {

    @Mapping(source = "idGestion", target = "idManagement")
    @Mapping(source = "tipo", target = "type", qualifiedByName = "generarType")
    @Mapping(source = "descripcion", target = "description")
    @Mapping(source = "fechaCreacion", target = "creationDate")
    @Mapping(source = "fechaVencimiento", target = "expirationDate")
    @Mapping(source = "estado", target = "status1", qualifiedByName = "generarStatus1")
    @Mapping(source = "observaciones", target = "observations")
    @Mapping(source = "idCaso", target = "idCase")
    @Mapping(source = "idAbogado", target = "idLawyer")
    @Mapping(source = "idHistorial", target = "idRecord")
    GestionDto toDto(GestionEntity entity);

    List<GestionDto> toDto(Iterable<GestionEntity> entities);

    @InheritInverseConfiguration
    @Mapping(source = "type", target = "tipo", qualifiedByName = "generarTipo")
    @Mapping(source = "status1", target = "estado", qualifiedByName = "generarEstado1")
    GestionEntity toEntity(GestionDto dto);

    @Mapping(source = "type", target = "tipo", qualifiedByName = "generarTipo")
    @Mapping(source = "description", target = "descripcion")
    @Mapping(source = "creationDate", target = "fechaCreacion")
    @Mapping(source = "expirationDate", target = "fechaVencimiento")
    @Mapping(source = "status1", target = "estado", qualifiedByName = "generarEstado1")
    @Mapping(source = "observations", target = "observaciones")
    @Mapping(source = "idCase", target = "idCaso")
    @Mapping(source = "idLawyer", target = "idAbogado")
    @Mapping(source = "idRecord", target = "idHistorial")
    void modificarEntityFromDto(ModGestionDto mod, @MappingTarget GestionEntity entity);
}

