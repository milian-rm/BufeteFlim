package org.flim.bufeteflim.dominio.repository;

import org.flim.bufeteflim.dominio.dto.GestionDto;

import java.util.List;

public interface GestionRepository {

    List<GestionDto> obtenerTodo();
    GestionDto buscarPorId(Long id);
    GestionDto buscarPorEstado(String estado);
    GestionDto guardarGestion(GestionDto gestionDto);
    GestionDto modificarGestion(Long id, GestionDto gestionDto);
    void eliminarGestion(Long id);
}
