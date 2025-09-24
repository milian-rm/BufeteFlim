package org.flim.bufeteflim.persistence.mapper;

import org.flim.bufeteflim.dominio.dto.AbogadoDto;
import org.flim.bufeteflim.dominio.dto.CasoDto;
import org.flim.bufeteflim.dominio.dto.GestionDto;
import org.flim.bufeteflim.dominio.dto.HistorialDto;
import org.flim.bufeteflim.dominio.dto.ModGestionDto;
import org.flim.bufeteflim.persistence.entity.AbogadoEntity;
import org.flim.bufeteflim.persistence.entity.CasoEntity;
import org.flim.bufeteflim.persistence.entity.GestionEntity;
import org.flim.bufeteflim.persistence.entity.HistorialEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TypeMapper.class, Status1Mapper.class})
public interface GestionMapper {

    // Mapeo de Entidad a DTO
    @Mapping(source = "idGestion", target = "idManagement")
    @Mapping(source = "tipo", target = "type")
    @Mapping(source = "descripcion", target = "description")
    @Mapping(source = "fechaCreacion", target = "creationDate")
    @Mapping(source = "fechaVencimiento", target = "expirationDate")
    @Mapping(source = "estado", target = "status1")
    @Mapping(source = "observaciones", target = "observations")
    GestionDto toDto(GestionEntity entity);

    List<GestionDto> toDto(Iterable<GestionEntity> entities);

    // Mapeo de DTO a Entidad
    @InheritInverseConfiguration
    @Mapping(source = "type", target = "tipo")
    @Mapping(source = "status1", target = "estado")
    GestionEntity toEntity(GestionDto dto);

    // Mapeo para modificar
    @Mapping(source = "type", target = "tipo")
    @Mapping(source = "description", target = "descripcion")
    @Mapping(source = "creationDate", target = "fechaCreacion")
    @Mapping(source = "expirationDate", target = "fechaVencimiento")
    @Mapping(source = "status1", target = "estado")
    @Mapping(source = "observations", target = "observaciones")
    void modificarEntityFromDto(ModGestionDto mod, @MappingTarget GestionEntity entity);

    // Métodos para crear entidades parciales a partir de DTOs.
    default CasoEntity casoFromDto(CasoDto dto) {
        if (dto == null) {
            return null;
        }
        CasoEntity caso = new CasoEntity();
        caso.setIdCaso(dto.idCaso());
        return caso;
    }

    default AbogadoEntity abogadoFromDto(AbogadoDto dto) {
        if (dto == null) {
            return null;
        }
        AbogadoEntity abogado = new AbogadoEntity();
        abogado.setIdAbogado(dto.idAbogado());
        return abogado;
    }
}