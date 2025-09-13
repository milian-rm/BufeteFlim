package org.flim.bufeteflim.dominio.repository;

import java.util.List;

import org.flim.bufeteflim.dominio.dto.AbogadoDto;
import org.flim.bufeteflim.dominio.dto.ModAbogadoDto;

public interface AbogadoRepository {
    
    List<AbogadoDto> obtenerTodo();
    AbogadoDto buscarPorId(Long id);
    AbogadoDto guardarAbogado(AbogadoDto abogadoDto);
    AbogadoDto modificarAbogado(Long id, ModAbogadoDto modAbogado);
    void eliminarAbogado(Long id);
    
}
