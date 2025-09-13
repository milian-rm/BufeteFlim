package org.flim.bufeteflim.persistence.mapper;

import org.flim.bufeteflim.dominio.dto.CasoDto;
import org.flim.bufeteflim.dominio.dto.ModCasoDto;
import org.flim.bufeteflim.persistence.entity.CasoEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = {StatusMapper.class, CaseTypeMapper.class})
public interface CasoMapper {

    @Mapping(source = "titulo", target = "title")
    @Mapping(source = "descripcion", target = "description")
    @Mapping(source = "fechaInicio", target = "startDate")
    @Mapping(source = "fechaCierre", target = "closingDate")
    @Mapping(source = "estado", target = "status", qualifiedByName = "generarStatus")
    @Mapping(source = "tipoCaso", target = "caseType", qualifiedByName = "generarCaseType")
    CasoDto toDto(CasoEntity entity);

    List<CasoDto> toDto(Iterable<CasoEntity> entities);

    @InheritInverseConfiguration
    @Mapping(source = "status", target = "estado", qualifiedByName = "generarEstado")
    @Mapping(source = "caseType", target = "tipoCaso", qualifiedByName = "generarTipoCaso")
    CasoEntity toEntity(CasoDto dto);

    @Mapping(source = "title", target = "titulo")
    @Mapping(source = "description", target = "descripcion")
    @Mapping(source = "startDate", target = "fechaInicio")
    @Mapping(source = "closingDate", target = "fechaCierre")
    void modificarEntityFromDto(ModCasoDto mod, @MappingTarget CasoEntity entity);
}
