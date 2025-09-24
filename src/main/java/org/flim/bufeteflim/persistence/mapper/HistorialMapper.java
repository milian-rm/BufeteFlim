package org.flim.bufeteflim.persistence.mapper;

import org.flim.bufeteflim.dominio.dto.*;
import org.flim.bufeteflim.persistence.entity.AbogadoEntity;
import org.flim.bufeteflim.persistence.entity.CasoEntity;
import org.flim.bufeteflim.persistence.entity.HistorialEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CasoMapper.class, AbogadoMapper.class})
public interface HistorialMapper {

    @Mapping(source = "idHistorial", target = "code")
    @Mapping(source = "descripcion", target = "description")
    @Mapping(source = "idAbogado", target = "idLawyer")
    @Mapping(source = "idCaso", target = "idCase")
    HistorialDto toDto(HistorialEntity entity);

    List<HistorialDto> toDto(Iterable<HistorialEntity> entities);

    @InheritInverseConfiguration
    @Mapping(target = "idAbogado", expression = "java(abogadoFromDto(dto.idLawyer()))")
    @Mapping(target = "idCaso", expression = "java(casoFromDto(dto.idCase()))")
    HistorialEntity toEntity(HistorialDto dto);

    @Mapping(source = "description", target = "descripcion")
    @Mapping(target = "idAbogado", expression = "java(abogadoFromDto(mod.idLawyer()))")
    @Mapping(target = "idCaso", expression = "java(casoFromDto(mod.idCase()))")
    void modificarEntityFromDto(ModHistorialDto mod, @MappingTarget HistorialEntity entity);

    @Mapping(source = "idHistorial", target = "code")
    @Mapping(source = "descripcion", target = "description")
    VerHistorialDto verHistorial(HistorialEntity entity);

    default CasoEntity casoFromDto(VerCasoDto dto) {
        if (dto == null || dto.idCaso() == null) {
            return null;
        }
        CasoEntity caso = new CasoEntity();
        caso.setIdCaso(dto.idCaso());
        return caso;
    }

    default AbogadoEntity abogadoFromDto(VerAbogadoDto dto) {
        if (dto == null || dto.idAbogado() == null) {
            return null;
        }
        AbogadoEntity abogado = new AbogadoEntity();
        abogado.setIdAbogado(dto.idAbogado());
        return abogado;
    }

}
