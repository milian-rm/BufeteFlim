package org.flim.bufeteflim.dominio.repository;

import org.flim.bufeteflim.dominio.dto.DocumentoDto;
import org.flim.bufeteflim.dominio.dto.ModDocumentoDto;

import java.util.List;

public interface DocumentoRepository {
    List<DocumentoDto> obtenerTodo();
    DocumentoDto buscarPorIdDocumento(Long idDocumento);
    DocumentoDto guardarDocumento(DocumentoDto documentoDto);
    DocumentoDto modificarDocumento(Long idDocumento, ModDocumentoDto modDocumentoDto);
    void eliminarDocumento(Long idDocumento);
}
