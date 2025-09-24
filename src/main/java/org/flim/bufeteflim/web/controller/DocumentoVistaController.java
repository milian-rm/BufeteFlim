package org.flim.bufeteflim.web.controller;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.flim.bufeteflim.dominio.dto.DocumentoDto;
import org.flim.bufeteflim.dominio.repository.DocumentoRepository;
import org.flim.bufeteflim.persistence.entity.DocumentoEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ViewScoped
@Data
public class DocumentoVistaController {
    @Autowired
    DocumentoRepository documentoService;
    private List<DocumentoDto> documentos;
    private DocumentoEntity documentoSeleccionado;
    private static Logger logger = LoggerFactory.getLogger(DocumentoVistaController.class);

    @PostConstruct
    public void init(){
        cargarDatos();
    }

    public void cargarDatos(){
        this.documentos = this.documentoService.obtenerTodo();
        this.documentos.forEach(documento -> logger.info(documento.toString()));
    }
}
