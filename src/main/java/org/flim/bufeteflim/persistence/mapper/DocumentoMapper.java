package org.flim.bufeteflim.persistence.mapper;

import org.flim.bufeteflim.dominio.dto.DocumentoDto;
import org.flim.bufeteflim.dominio.dto.ModDocumentoDto;
import org.flim.bufeteflim.persistence.entity.DocumentoEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {DocumentoMapper.class, CasoMapper.class})
public interface DocumentoMapper {

    @Mapping(source = "nombre", target = "name")
    @Mapping(source = "tipoDocumento", target = "documentType", qualifiedByName = "generarDocumentType")
    @Mapping(source = "caso", target = "casoDto")
    DocumentoDto toDto(DocumentoEntity entity);

    @InheritInverseConfiguration
    @Mapping(source = "documentType", target = "tipoDocumento", qualifiedByName = "generarTipoDocumento")
    DocumentoEntity toEntity(DocumentoDto dto);

    @Mapping(source = "name", target = "nombre")
    @Mapping(source = "documentType", target = "tipoDocumento", qualifiedByName = "generarTipoDocumento")
    @Mapping(source = "casoDto", target = "caso")
    void modificarEntityFromDto(ModDocumentoDto mod, @MappingTarget DocumentoEntity entity);
}
