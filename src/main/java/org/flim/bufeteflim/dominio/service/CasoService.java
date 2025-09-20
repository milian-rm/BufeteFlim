package org.flim.bufeteflim.dominio.service;

import java.util.List;

import org.flim.bufeteflim.dominio.dto.CasoDto;
import org.flim.bufeteflim.dominio.dto.ModCasoDto;
import org.flim.bufeteflim.dominio.repository.CasoRepository;
import org.springframework.stereotype.Service;

@Service
public class CasoService {
    private final CasoRepository casoRepository;

    public CasoService(CasoRepository casoRepository){
        this.casoRepository = casoRepository;
    }

    public List<CasoDto> obtenerTodo(){
        return this.casoRepository.obtenerTodo();
    }

    public CasoDto buscarPorId(Long id){
        return this.casoRepository.buscarPorId(id);
    }

    public List<CasoDto> buscarPorEstado(String estado){
        return this.casoRepository.buscarPorEstado(estado);
    }

    public CasoDto guardarCaso(CasoDto casoDto){
        return this.casoRepository.guardarCaso(casoDto);
    }

    public CasoDto modificarCaso(Long id, ModCasoDto modCasoDto){
        return this.casoRepository.modificarCaso(id, modCasoDto);
    }

    public void eliminarCaso(Long id){
        this.casoRepository.eliminarCaso(id);
    }
}
