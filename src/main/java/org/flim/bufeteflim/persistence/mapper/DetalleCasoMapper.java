package org.flim.bufeteflim.persistence.mapper;

import org.flim.bufeteflim.dominio.MaritalStatus;
import org.flim.bufeteflim.dominio.dto.CasoDto;
import org.flim.bufeteflim.dominio.dto.ModDetalleCasoDto;
import org.flim.bufeteflim.dominio.dto.DetalleCasoDto;
import org.flim.bufeteflim.dominio.dto.ParteDto;
import org.flim.bufeteflim.persistence.entity.CasoEntity;
import org.flim.bufeteflim.persistence.entity.DetalleCasoEntity;
import org.flim.bufeteflim.persistence.entity.ParteEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = {RoleMapper.class, CasoMapper.class, ParteMapper.class})
public interface DetalleCasoMapper {

    @Mapping(source = "codigo", target = "codeDetail")
    @Mapping(source = "parte", target = "idComponent")
    @Mapping(source = "caso", target = "idCase")
    @Mapping(source = "rolEnCaso", target = "role")
    DetalleCasoDto toDto(DetalleCasoEntity detalleEntity);

    List<DetalleCasoDto> toDto(Iterable<DetalleCasoEntity> entities);

    @InheritInverseConfiguration
    @Mapping(source = "role", target = "rolEnCaso", qualifiedByName = "generarRol")
    @Mapping(target = "parte", expression = "java(parteFromDto(detalleDto.idComponent()))")
    @Mapping(target = "caso", expression = "java(casoFromDto(detalleDto.idCase()))")
    DetalleCasoEntity toEntity(DetalleCasoDto detalleDto);

    @Mapping(target = "parte", expression = "java(parteFromDto(mod.idComponent()))")
    @Mapping(target = "caso", expression = "java(casoFromDto(mod.idCase()))")
    @Mapping(source = "role", target = "rolEnCaso")
    void modificarEntityFromDto(ModDetalleCasoDto mod, @MappingTarget DetalleCasoEntity entity);


    default CasoEntity casoFromDto(CasoDto dto) {
        if (dto == null || dto.idCaso() == null) {
            return null;
        }
        CasoEntity caso = new CasoEntity();
        caso.setIdCaso(dto.idCaso());
        return caso;
    }

    default ParteEntity parteFromDto(ParteDto dto){
        if (dto == null || dto.idParte() == null){
            return null;
        }
        ParteEntity parte = new ParteEntity();
        parte.setIdParte(dto.idParte());
        return parte;
    }

}
