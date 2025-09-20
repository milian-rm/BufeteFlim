package org.flim.bufeteflim.dominio.repository;

import java.util.List;

import org.flim.bufeteflim.dominio.dto.CasoDto;
import org.flim.bufeteflim.dominio.dto.ModCasoDto;

public interface CasoRepository {
    List<CasoDto> obtenerTodo();
    CasoDto buscarPorId(Long id);
    List<CasoDto> buscarPorEstado(String estado);
    CasoDto guardarCaso(CasoDto casoDto);
    CasoDto modificarCaso(Long id, ModCasoDto modCaso);
    void eliminarCaso(Long id);
}
