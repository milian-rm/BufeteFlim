package org.flim.bufeteflim.persistence.mapper;

import org.flim.bufeteflim.dominio.dto.InsumoDto;
import org.flim.bufeteflim.dominio.dto.ModInsumoDto;
import org.flim.bufeteflim.persistence.entity.InsumoEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InsumoMapper {

    @Mapping(source = "codigo", target = "codeSupply")
    @Mapping(source = "descripcion", target = "description")
    @Mapping(source = "cantidad", target = "cuantity")
    @Mapping(source = "costoUnitario", target = "unitaryCost")
    @Mapping(source = "costo", target = "cost")
    InsumoDto toDto(InsumoEntity entity);

    List<InsumoDto> toDto(Iterable<InsumoEntity> entities);

    @InheritInverseConfiguration
    InsumoEntity toEntity(InsumoDto dto);

    @Mapping(source = "description", target = "descripcion")
    @Mapping(source = "cuantity", target = "cantidad")
    @Mapping(source = "unitaryCost", target = "costoUnitario")
    @Mapping(source = "cost", target = "costo")
    void modificarEntityFromDto(ModInsumoDto dto, @MappingTarget InsumoEntity entity);
}
