package org.flim.bufeteflim.persistence.mapper;

import org.flim.bufeteflim.dominio.dto.AbogadoDto;
import org.flim.bufeteflim.dominio.dto.ModTimbreDto;
import org.flim.bufeteflim.dominio.dto.TimbreDto;
import org.flim.bufeteflim.persistence.entity.AbogadoEntity;
import org.flim.bufeteflim.persistence.entity.TimbreEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = {RingTypeMapper.class, AbogadoMapper.class})
public interface TimbreMapper {

    @Mapping(source = "noTimbre", target = "noRing")
    @Mapping(source = "tipoTimbre", target = "ringType", qualifiedByName = "generarRingType")
    @Mapping(source = "abogado", target = "abogadoDto")
    TimbreDto toDto(TimbreEntity entity);

    List<TimbreDto> toDto(Iterable<TimbreEntity> entities);

    @InheritInverseConfiguration
    @Mapping(source = "ringType", target = "tipoTimbre", qualifiedByName = "generarTipoTimbre")
    @Mapping(target = "abogado", expression = "java(abogadoFromDto(dto.abogadoDto()))")
    TimbreEntity toEntity(TimbreDto dto);

    @Mapping(source = "ringType", target = "tipoTimbre", qualifiedByName = "generarTipoTimbre")
    @Mapping(target = "abogado", expression = "java(abogadoFromDto(mod.abogadoDto()))")
    void modificarEntityFromDto(ModTimbreDto mod, @MappingTarget TimbreEntity entity);

    default AbogadoEntity abogadoFromDto(AbogadoDto dto) {
        if (dto == null || dto.idAbogado() == null) {
            return null;
        }
        AbogadoEntity abogado = new AbogadoEntity();
        abogado.setIdAbogado(dto.idAbogado());
        return abogado;
    }
}
