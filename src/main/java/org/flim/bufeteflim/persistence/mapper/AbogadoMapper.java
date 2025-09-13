package org.flim.bufeteflim.persistence.mapper;

import java.util.List;

import org.flim.bufeteflim.dominio.dto.AbogadoDto;
import org.flim.bufeteflim.dominio.dto.ModAbogadoDto;
import org.flim.bufeteflim.persistence.entity.AbogadoEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AbogadoMapper {

    @Mapping(source = "nombre", target = "name")
    @Mapping(source = "apellido", target = "lastName")
    @Mapping(source = "dpi", target = "dpi1")
    @Mapping(source = "noColegiadoActivo", target = "numActiveCollegiate")
    @Mapping(source = "correo", target = "email")
    @Mapping(source = "telefono", target = "phone")
    @Mapping(source = "especialidad", target = "specialty", qualifiedByName = "generarSpecialty")
    AbogadoDto toDto(AbogadoEntity entity);
    
    List<AbogadoDto> toDto(Iterable<AbogadoEntity> entities);

    @InheritInverseConfiguration
    @Mapping(source = "specialty", target = "especialidad", qualifiedByName = "generarEspecialidad")
    AbogadoEntity toEntity(AbogadoDto dto);

    void modificarEntityFromDto(ModAbogadoDto mod, @MappingTarget AbogadoEntity entity);
}