package org.flim.bufeteflim.dominio.repository;

import org.flim.bufeteflim.dominio.dto.ModTimbreDto;
import org.flim.bufeteflim.dominio.dto.TimbreDto;

import java.util.List;

public interface TimbreRepository {
    List<TimbreDto> obtenerTodo();
    TimbreDto buscarPorNo(Long noRing);
    TimbreDto guardarTimbre(TimbreDto timbreDto);
    TimbreDto modificarTimbre(Long noRing, ModTimbreDto modTimbreDto);
    void eliminarTimbre(Long noRing);
}
