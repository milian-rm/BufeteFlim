package org.flim.bufeteflim.dominio.service;

import org.flim.bufeteflim.dominio.dto.GestionDto;
import org.flim.bufeteflim.dominio.dto.ModGestionDto;
import org.flim.bufeteflim.dominio.repository.GestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestionService {
    private final GestionRepository gestionRepository;

    public GestionService(GestionRepository gestionRepository){
        this.gestionRepository = gestionRepository;
    }

    public List<GestionDto> obtenerTodo(){
        return this.gestionRepository.obtenerTodo();
    }
    public GestionDto buscarPorId(Long id){
        return this.gestionRepository.buscarPorId(id);
    }

    public List<GestionDto> buscarPorEstado(String estado){
        return this.gestionRepository.buscarPorEstado(estado);
    }

    public GestionDto guardarGestion(GestionDto gestionDto){
        return this.gestionRepository.guardarGestion(gestionDto);
    }

    public GestionDto modificarGestion(Long id, ModGestionDto modGestionDto){
        return this.gestionRepository.modificarGestion(id, modGestionDto);
    }

    public void eliminarGestion(Long id){
        this.gestionRepository.eliminarGestion(id);
    }
}
