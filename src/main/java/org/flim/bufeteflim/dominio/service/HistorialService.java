package org.flim.bufeteflim.dominio.service;

import java.util.List;

import org.flim.bufeteflim.dominio.dto.HistorialDto;
import org.flim.bufeteflim.dominio.dto.ModHistorialDto;
import org.flim.bufeteflim.dominio.repository.HistorialRepository;
import org.springframework.stereotype.Service;

@Service
public class HistorialService {
    private final HistorialRepository historialRepository;

    public HistorialService(HistorialRepository historialRepository){
        this.historialRepository = historialRepository;
    }

    public List<HistorialDto> obtenerTodo(){
        return this.historialRepository.obtenerTodo();
    }

    public HistorialDto buscarPorCodigo(Long id){
        return this.historialRepository.buscarPorId(id);
    }

    public HistorialDto guardarHistorial(HistorialDto historialDto){
        return this.historialRepository.guardarHistorial(historialDto);
    }

    public HistorialDto modificarHistorial(Long id, ModHistorialDto modHistorialDto){
        return this.historialRepository.modificarHistorial(id, modHistorialDto);
    }

    public void eliminarPelicula(Long id){
        this.historialRepository.eliminarHistorial(id);
    }
}
