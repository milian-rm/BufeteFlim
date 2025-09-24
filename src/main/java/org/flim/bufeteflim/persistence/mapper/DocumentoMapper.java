package org.flim.bufeteflim.persistence.mapper;

import org.flim.bufeteflim.dominio.dto.CasoDto;
import org.flim.bufeteflim.dominio.dto.DocumentoDto;
import org.flim.bufeteflim.dominio.dto.ModDocumentoDto;
import org.flim.bufeteflim.dominio.dto.VerCasoDto;
import org.flim.bufeteflim.persistence.entity.CasoEntity;
import org.flim.bufeteflim.persistence.entity.DocumentoEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = {DocumentTypeMapper.class, CasoMapper.class})
public interface DocumentoMapper {

    @Mapping(source = "nombre", target = "name")
    @Mapping(source = "tipoDocumento", target = "documentType", qualifiedByName = "generarDocumentType")
    @Mapping(source = "caso", target = "casoDto")
    DocumentoDto toDto(DocumentoEntity entity);

    List<DocumentoDto> toDto(Iterable<DocumentoEntity> entities);

    @InheritInverseConfiguration
    @Mapping(source = "documentType", target = "tipoDocumento", qualifiedByName = "generarTipoDocumento")
    @Mapping(target = "caso", expression = "java(casoFromDto(dto.casoDto()))")
    DocumentoEntity toEntity(DocumentoDto dto);

    @Mapping(source = "name", target = "nombre")
    @Mapping(source = "documentType", target = "tipoDocumento", qualifiedByName = "generarTipoDocumento")
    @Mapping(target = "caso", expression = "java(casoFromDto(mod.casoDto()))")
    void modificarEntityFromDto(ModDocumentoDto mod, @MappingTarget DocumentoEntity entity);

    default CasoEntity casoFromDto(VerCasoDto dto) {
        if (dto == null || dto.idCaso() == null) {
            return null;
        }
        CasoEntity caso = new CasoEntity();
        caso.setIdCaso(dto.idCaso());
        return caso;
    }
}
