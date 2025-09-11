package org.flim.bufeteflim.dominio.repository;

import org.flim.bufeteflim.dominio.dto.ModParteDto;
import org.flim.bufeteflim.dominio.dto.ParteDto;

import java.util.List;

public interface ParteRepository {
    List<ParteDto> obtenerTodo();
    public ParteDto buscarPorCodigo(Long codigo);
    ParteDto guardarParte(ParteDto parteDto);
    ParteDto modificarParte(Long codigo, ModParteDto modParte);
    void eliminarParte(Long codigo);
}
