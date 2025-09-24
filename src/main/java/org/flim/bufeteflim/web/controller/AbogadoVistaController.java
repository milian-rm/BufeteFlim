package org.flim.bufeteflim.web.controller;


import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.flim.bufeteflim.dominio.dto.AbogadoDto;
import org.flim.bufeteflim.dominio.repository.AbogadoRepository;
import org.flim.bufeteflim.dominio.service.AbogadoService;
import org.flim.bufeteflim.persistence.entity.AbogadoEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@ViewScoped
@Data
public class AbogadoVistaController{
    @Autowired
    AbogadoRepository abogadoService;
    private List<AbogadoDto> abogados;
    private AbogadoEntity usuarioSeleccionado;
    private static Logger logger = LoggerFactory.getLogger(AbogadoVistaController.class);

    @PostConstruct
    public void init(){
        cargarDatos();
    }

    public void cargarDatos(){
        this.abogados = this.abogadoService.obtenerTodo();
        this.abogados.forEach(usuario -> logger.info(usuario.toString()));
    }
}
