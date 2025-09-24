    package org.flim.bufeteflim.web.controller;

    import jakarta.annotation.PostConstruct;
    import jakarta.faces.view.ViewScoped;
    import lombok.Data;
    import org.flim.bufeteflim.dominio.dto.InsumoDto;
    import org.flim.bufeteflim.dominio.repository.InsumoRepository;
    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Component;

    import java.util.List;

    @Component
    @ViewScoped
    @Data
    public class InsumoVistaController{
        @Autowired
        InsumoRepository insumoRepository;
        private List<InsumoDto> insumo;
        public static Logger logger = LoggerFactory.getLogger(InsumoVistaController.class);

        @PostConstruct
        public void init(){cargarDatos();}

        public void cargarDatos(){
            this.insumo = this.insumoRepository.obtenerTodo();
            this.insumo.forEach(insumo -> logger.info(insumo.toString()));
        }
    }
