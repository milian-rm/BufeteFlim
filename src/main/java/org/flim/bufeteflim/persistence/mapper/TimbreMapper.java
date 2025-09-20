package org.flim.bufeteflim.persistence.mapper;

import org.flim.bufeteflim.dominio.dto.ModTimbreDto;
import org.flim.bufeteflim.dominio.dto.TimbreDto;
import org.flim.bufeteflim.persistence.entity.TimbreEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = {RingTypeMapper.class})
public interface TimbreMapper {
    @Mapping(source = "tipo", target = "type", qualifiedByName = "generarRingType")
    @Mapping(source = "idAbogado", target = "idLawyer")
    TimbreDto toDto(TimbreEntity entity);

    List<TimbreDto> toDto(Iterable<TimbreEntity> entities);

    @InheritInverseConfiguration
    @Mapping(source = "type", target = "tipo", qualifiedByName = "generarTipoTimbre")
    TimbreEntity toEntity(TimbreDto dto);

    @Mapping(source = "type", target = "tipo", qualifiedByName = "generarTipoTimbre")
    @Mapping(source = "idLawyer", target = "idAbogado")
    void modificarEntityFromDto(ModTimbreDto mod, @MappingTarget TimbreEntity entity);
}
