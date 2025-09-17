package org.flim.bufeteflim.dominio.repository;

import org.flim.bufeteflim.dominio.dto.HistorialDto;
import org.flim.bufeteflim.dominio.dto.ModHistorialDto;

import java.util.List;

public interface HistorialRepository {
    List<HistorialDto> obtenerTodo();
    HistorialDto buscarPorId(Long id);
    HistorialDto guardarHistorial(HistorialDto historialDto);
    HistorialDto modificarHistorial(Long id, ModHistorialDto modHistorial);
    void eliminarHistorial(Long id);
}
