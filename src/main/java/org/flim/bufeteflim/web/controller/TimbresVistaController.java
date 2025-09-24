package org.flim.bufeteflim.web.controller;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.flim.bufeteflim.dominio.dto.TimbreDto;
import org.flim.bufeteflim.dominio.repository.TimbreRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ViewScoped
@Data
public class TimbresVistaController {
    @Autowired
    TimbreRepository timbreRepository;
    private List<TimbreDto> timbres;
    public static Logger logger = LoggerFactory.getLogger(TimbresVistaController.class);

    @PostConstruct
    public void init(){cargarDatos();}

    public void cargarDatos(){
        this.timbres = this.timbreRepository.obtenerTodo();
        this.timbres.forEach(timbre -> logger.info(timbre.toString()));
    }
}
