package org.flim.bufeteflim.web.controller;


import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.flim.bufeteflim.dominio.dto.AbogadoDto;
import org.flim.bufeteflim.dominio.dto.CasoDto;
import org.flim.bufeteflim.dominio.dto.HistorialDto;
import org.flim.bufeteflim.dominio.repository.AbogadoRepository;
import org.flim.bufeteflim.dominio.repository.CasoRepository;
import org.flim.bufeteflim.dominio.repository.HistorialRepository;
import org.flim.bufeteflim.dominio.service.AbogadoService;
import org.flim.bufeteflim.persistence.entity.AbogadoEntity;
import org.flim.bufeteflim.persistence.entity.CasoEntity;
import org.flim.bufeteflim.persistence.entity.HistorialEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ViewScoped
@Data
public class HistorialVistaController{
    @Autowired
    HistorialRepository historialService;
    private List<HistorialDto> historiales;
    private HistorialEntity historialSeleccionado;
    private static Logger logger = LoggerFactory.getLogger(HistorialVistaController.class);

    @PostConstruct
    public void init(){
        cargarDatos();
    }

    public void cargarDatos(){
        this.historiales = this.historialService.obtenerTodo();
        this.historiales.forEach(caso -> logger.info(caso.toString()));
    }
}
