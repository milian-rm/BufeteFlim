package org.flim.bufeteflim.persistence.mapper;

import org.flim.bufeteflim.dominio.dto.HistorialDto;
import org.flim.bufeteflim.dominio.dto.ModHistorialDto;
import org.flim.bufeteflim.persistence.entity.HistorialEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HistorialMapper {


    @Mapping(source = "descripcion", target = "description")
    @Mapping(source = "idAbogado", target = "idLawyer")
    @Mapping(source = "idCaso", target = "idCase")
    HistorialDto toDto(HistorialEntity entity);

    List<HistorialDto> toDto(Iterable<HistorialEntity> entities);

    @InheritInverseConfiguration
    HistorialEntity toEntity(HistorialDto dto);

    void modificarEntityFromDto(ModHistorialDto mod, @MappingTarget HistorialEntity entity);
}
