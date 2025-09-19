package org.flim.bufeteflim.dominio.repository;

import org.flim.bufeteflim.dominio.dto.GestionDto;
import org.flim.bufeteflim.dominio.dto.ModGestionDto;

import java.util.List;

public interface GestionRepository {

    List<GestionDto> obtenerTodo();
    GestionDto buscarPorId(Long id);
    List<GestionDto> buscarPorEstado(String estado);
    GestionDto guardarGestion(GestionDto gestionDto);
    GestionDto modificarGestion(Long id, ModGestionDto ModGestionDto);
    void eliminarGestion(Long id);
}
