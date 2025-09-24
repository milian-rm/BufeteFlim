package org.flim.bufeteflim.web.controller;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.flim.bufeteflim.dominio.dto.EventoDto;
import org.flim.bufeteflim.dominio.repository.EventoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ViewScoped
@Data
public class EventoVistaController {
    @Autowired
    EventoRepository eventoRepository;
    private List<EventoDto> eventos;
    public static Logger logger = LoggerFactory.getLogger(EventoVistaController.class);

    @PostConstruct
    public void init(){cargarDatos();}

    public void cargarDatos(){
        this.eventos = this.eventoRepository.obtenerTodo();
        this.eventos.forEach(evento -> logger.info(evento.toString()));
    }
}
