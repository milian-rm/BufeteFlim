package org.flim.bufeteflim.dominio.service;

import org.flim.bufeteflim.dominio.repository.DetalleCasoRepository;
import org.flim.bufeteflim.dominio.dto.*;

import java.util.List;

public class DetalleCasoService {
    private final DetalleCasoRepository detalleCasoRepository;

    public DetalleCasoRepository(DetalleCasoRepository detalleCasoRepository){
        this.detalleCasoRepository = detalleCasoRepository;
    }

    public List<DetalleCasoDto> obtenerTodo(){
        return this.detalleCasoRepository.obtenertodo();
    }

    public DetalleCasoDto buscarPorCodigo(Long id){
        return this.detalleCasoRepository.buscarPorCodigo(id);
    }

    public DetalleCasoDto guardarDetalleCaso(DetalleCasoDto detalleCasoDto){
        return this.detalleCasoRepository.guardarDetalleCaso(detalleCasoDto);
    }

    public DetalleCasoDto modificarDetalleCaso(Long id, ModDetalleCasoDto modDetalleCasoDto){
        return this.detalleCasoRepository.modificarDetalleCaso(id, modDetalleCasoDto);
    }

    public void eliminarPelicula(Long id){
        this.detalleCasoRepository.eliminarDetalleCaso(id);
    }
}
