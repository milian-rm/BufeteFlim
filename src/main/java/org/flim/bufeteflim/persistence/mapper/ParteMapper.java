package org.flim.bufeteflim.persistence.mapper;

import org.flim.bufeteflim.dominio.MaritalStatus;
import org.flim.bufeteflim.dominio.dto.ModParteDto;
import org.flim.bufeteflim.dominio.dto.ParteDto;
import org.flim.bufeteflim.persistence.entity.ParteEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = {GenderMapper.class, MaritalStatus.class, RoleMapper.class})
public interface ParteMapper {

    @Mapping(source = "nombre", target = "name")
    @Mapping(source = "apellido", target = "lastName")
    @Mapping(source = "dpi", target = "dpi")
    @Mapping(source = "estadoCivil" , target = "maritalStatus")
    @Mapping(source = "fechaNacimiento", target = "birthdate")
    @Mapping(source = "oficio", target = "job")
    @Mapping(source = "sexo", target = "gender")
    @Mapping(source = "lugarNacimiento", target = "birthplace")
    @Mapping(source = "etnia", target = "ethnicity")
    @Mapping(source = "domicilio", target = "address")
    @Mapping(source = "telefono", target = "phoneNumber")
    @Mapping(source = "nit", target = "nit")
    @Mapping(source = "rol", target = "role")
    ParteDto toDto(ParteEntity parteEntity);

    List<ParteDto> toDto(Iterable<ParteEntity> entities);

    @InheritInverseConfiguration
    @Mapping(source = "gender", target = "genero", qualifiedByName = "generarGenero")
    @Mapping(source = "maritalStatus", target = "estadoCivil", qualifiedByName = "generarEstadoCivil")
    @Mapping(source = "role", target = "rol", qualifiedByName = "generarRol")
    ParteEntity toEntity(ParteDto parteDto);

    void modificarEntityFromDto(ModParteDto mod, @MappingTarget ParteEntity entity);


}
