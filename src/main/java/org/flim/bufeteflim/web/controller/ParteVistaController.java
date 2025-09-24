package org.flim.bufeteflim.web.controller;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.flim.bufeteflim.dominio.dto.ParteDto;
import org.flim.bufeteflim.dominio.repository.ParteRepository;
import org.flim.bufeteflim.persistence.entity.ParteEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ViewScoped
@Data
public class ParteVistaController {
    @Autowired
    ParteRepository parteService;
    private List<ParteDto> partes;
    private static Logger logger = LoggerFactory.getLogger(ParteVistaController.class);

    @PostConstruct
    public void init(){
        cargarDatos();
    }

    public void cargarDatos(){
        this.partes = this.parteService.obtenerTodo();
        this.partes.forEach(usuario -> logger.info(usuario.toString()));
    }
}
