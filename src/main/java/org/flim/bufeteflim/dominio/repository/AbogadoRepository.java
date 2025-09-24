package org.flim.bufeteflim.dominio.repository;

import java.util.List;

import org.flim.bufeteflim.dominio.dto.AbogadoDto;
import org.flim.bufeteflim.dominio.dto.ModAbogadoDto;


public interface AbogadoRepository {
    List<AbogadoDto> obtenerTodo();
    public AbogadoDto buscarPorId(Long idAbogado);
    AbogadoDto buscarPorNombre(String nombre);
    AbogadoDto guardarAbogado(AbogadoDto abogadoDto);
    AbogadoDto modificarAbogado(Long idAbogado, ModAbogadoDto modAbogado);
    void eliminarAbogado(Long id);
    
}
