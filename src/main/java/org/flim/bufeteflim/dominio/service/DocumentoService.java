package org.flim.bufeteflim.dominio.service;

import org.flim.bufeteflim.dominio.dto.DocumentoDto;
import org.flim.bufeteflim.dominio.dto.ModDocumentoDto;
import org.flim.bufeteflim.dominio.repository.DocumentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentoService {
    private final DocumentoRepository documentoRepository;

    public DocumentoService(DocumentoRepository documentoRepository){
        this.documentoRepository = documentoRepository;
    }

    public List<DocumentoDto> obtenerTodo(){
        return this.documentoRepository.obtenerTodo();
    }

    public DocumentoDto buscarPorIdDocumento(Long idDocumento){
        return this.documentoRepository.buscarPorIdDocumento(idDocumento);
    }

    public DocumentoDto guardarDocumento(DocumentoDto documentoDto){
        return this.documentoRepository.guardarDocumento(documentoDto);
    }

    public DocumentoDto modificarDocumento(Long idDocumento, ModDocumentoDto modDocumentoDto){
        return this.documentoRepository.modificarDocumento(idDocumento, modDocumentoDto);
    }

    public void eliminarDocumento(Long idDocumento){
        this.documentoRepository.eliminarDocumento(idDocumento);
    }
}
