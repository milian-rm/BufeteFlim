package org.flim.bufeteflim.persistence.mapper;

import org.flim.bufeteflim.dominio.MaritalStatus;
import org.flim.bufeteflim.dominio.dto.ModDetalleCasoDto;
import org.flim.bufeteflim.dominio.dto.DetalleCasoDto;
import org.flim.bufeteflim.persistence.entity.DetalleCasoEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = {RoleMapper.class})
public interface DetalleCasoMapper {

    @Mapping(source = "codigo", target = "codeDetail")
    @Mapping(source = "idParte", target = "idComponent")
    @Mapping(source = "idCaso", target = "idCase")
    @Mapping(source = "rolEnCaso", target = "role")
    DetalleCasoDto toDto(DetalleCasoEntity parteEntity);

    List<DetalleCasoDto> toDto(Iterable<DetalleCasoEntity> entities);

    @InheritInverseConfiguration
    @Mapping(source = "role", target = "rolEnCaso", qualifiedByName = "generarRol")
    DetalleCasoEntity toEntity(DetalleCasoDto parteDto);

    @Mapping(source = "idComponent", target = "idParte")
    @Mapping(source = "idCase", target = "idCaso")
    @Mapping(source = "role", target = "rolEnCaso")
    void modificarEntityFromDto(ModDetalleCasoDto mod, @MappingTarget DetalleCasoEntity entity);


}
