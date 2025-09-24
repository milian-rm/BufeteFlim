package org.flim.bufeteflim.web.controller;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.flim.bufeteflim.dominio.dto.GestionDto;
import org.flim.bufeteflim.dominio.repository.GestionRepository;
import org.flim.bufeteflim.persistence.entity.GestionEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ViewScoped
@Data
    public class GestionVistaController {
    @Autowired
    GestionRepository gestionRepository;
    private List<GestionDto> gestiones;
    private GestionEntity gestionSeleccionado;
    private static Logger logger = LoggerFactory.getLogger(GestionVistaController.class);

    @PostConstruct
    public void init(){
        cargarDatos();
    }

    public void cargarDatos(){
        this.gestiones = this.gestionRepository.obtenerTodo();
        this.gestiones.forEach(gestion -> logger.info(gestion.toString()));
    }
}
