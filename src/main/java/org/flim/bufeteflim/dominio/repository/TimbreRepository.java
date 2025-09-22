package org.flim.bufeteflim.dominio.repository;

import org.flim.bufeteflim.dominio.dto.ModTimbreDto;
import org.flim.bufeteflim.dominio.dto.TimbreDto;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface TimbreRepository {
    List<TimbreDto> obtenerTodo();
    TimbreDto buscarPorNo(Long noTimbre);
    TimbreDto guardarTimbre(TimbreDto timbreDto);
    TimbreDto modificarTimbre(Long noTimbre, ModTimbreDto modTimbreDto);
    void eliminarTimbre(Long noTimbre);
}
