package org.flim.bufeteflim.web.controller;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.flim.bufeteflim.dominio.dto.DetalleCasoDto;
import org.flim.bufeteflim.dominio.repository.DetalleCasoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ViewScoped
@Data
public class DetalleCasoVistaController{
    @Autowired
    DetalleCasoRepository detalleCasoRepository;
    private List<DetalleCasoDto> detalleCasos;
    public static Logger logger = LoggerFactory.getLogger(DetalleCasoVistaController.class);

    @PostConstruct
    public void init(){cargarDatos();}

    public void cargarDatos(){
        this.detalleCasos = this.detalleCasoRepository.obtenertodo();
        this.detalleCasos.forEach(detalleCasos -> logger.info(detalleCasos.toString()));
    }
}
