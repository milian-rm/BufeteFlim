package org.flim.bufeteflim.persistence.mapper;

import java.util.List;

import org.flim.bufeteflim.dominio.dto.AbogadoDto;
import org.flim.bufeteflim.dominio.dto.ModAbogadoDto;
import org.flim.bufeteflim.dominio.dto.VerAbogadoDto;
import org.flim.bufeteflim.persistence.entity.AbogadoEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {SpecialtyMapper.class})
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

    @Named("mapearAbogadoDto")
    @InheritInverseConfiguration
    @Mapping(source = "specialty", target = "especialidad", qualifiedByName = "generarEspecialidad")
    AbogadoEntity toEntity(AbogadoDto dto);

    @Mapping(source = "name", target = "nombre")
    @Mapping(source = "lastName", target = "apellido")
    @Mapping(source = "dpi1", target = "dpi")
    @Mapping(source = "numActiveCollegiate", target = "noColegiadoActivo")
    @Mapping(source = "email", target = "correo")
    @Mapping(source = "phone", target = "telefono")
    @Mapping(source = "specialty", target = "especialidad", qualifiedByName = "generarEspecialidad")
    void modificarEntityFromDto(ModAbogadoDto mod, @MappingTarget AbogadoEntity entity);

    @Mapping(source = "nombre", target = "name")
    @Mapping(source = "apellido", target = "lastName")
    VerAbogadoDto verAbogado(AbogadoEntity entity);
}