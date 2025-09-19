package org.flim.bufeteflim.persistence;

import org.flim.bufeteflim.dominio.dto.DocumentoDto;
import org.flim.bufeteflim.dominio.dto.ModDocumentoDto;
import org.flim.bufeteflim.dominio.exception.DocumentoNoExisteException;
import org.flim.bufeteflim.dominio.exception.DocumentoYaExisteException;
import org.flim.bufeteflim.dominio.repository.DocumentoRepository;
import org.flim.bufeteflim.persistence.crud.CrudDocumentoEntity;
import org.flim.bufeteflim.persistence.entity.DocumentoEntity;
import org.flim.bufeteflim.persistence.mapper.DocumentoMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DocumentoEntityRepository implements DocumentoRepository {

    private final CrudDocumentoEntity crudDocumentoEntity;
    private final DocumentoMapper documentoMapper;

    public DocumentoEntityRepository(CrudDocumentoEntity crudDocumentoEntity, DocumentoMapper documentoMapper){
        this.crudDocumentoEntity = crudDocumentoEntity;
        this.documentoMapper = documentoMapper;
    }

    @Override
    public List<DocumentoDto> obtenerTodo() {
        return this.documentoMapper.toDto(this.crudDocumentoEntity.findAll());
    }

    @Override
    public DocumentoDto buscarPorIdDocumento(Long idDocumento) {
        return this.documentoMapper.toDto(this.crudDocumentoEntity.findById(idDocumento).orElse(null));
    }

    @Override
    public DocumentoDto guardarDocumento(DocumentoDto documentoDto) {
        if (this.crudDocumentoEntity.findFirstByNombre(documentoDto.name()) != null){
            throw new DocumentoYaExisteException(documentoDto.name());
        }else {
            DocumentoEntity documento = new DocumentoEntity();
            documento = this.documentoMapper.toEntity(documentoDto);
            this.crudDocumentoEntity.save(documento);
            return this.documentoMapper.toDto(documento);
        }
    }

    @Override
    public DocumentoDto modificarDocumento(Long idDocumento, ModDocumentoDto modDocumentoDto) {
        DocumentoEntity documento = this.crudDocumentoEntity.findById(idDocumento).orElse(null);
        if (documento == null){
            throw new DocumentoNoExisteException(idDocumento);
        }
        DocumentoEntity existente = this.crudDocumentoEntity.findFirstByNombre(modDocumentoDto.name());
        if (existente != null && !existente.getIdDocumento().equals(idDocumento)) {
            throw new DocumentoYaExisteException(modDocumentoDto.name());
        }
        this.documentoMapper.modificarEntityFromDto(modDocumentoDto, documento);
        return documentoMapper.toDto(this.crudDocumentoEntity.save(documento));
    }

    @Override
    public void eliminarDocumento(Long idDocumento) {
        DocumentoEntity documento = this.crudDocumentoEntity.findById(idDocumento).orElse(null);
        if (documento == null){
            throw new DocumentoNoExisteException(idDocumento);
        }else{
            this.crudDocumentoEntity.deleteById(idDocumento);
        }

    }
}
