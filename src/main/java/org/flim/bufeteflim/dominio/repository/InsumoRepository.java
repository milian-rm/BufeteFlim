package org.flim.bufeteflim.dominio.repository;

import org.flim.bufeteflim.dominio.dto.InsumoDto;
import org.flim.bufeteflim.dominio.dto.ModInsumoDto;

import java.util.List;

public interface InsumoRepository {
    List<InsumoDto> obtenerTodo();
    InsumoDto buscarPorCodigo(Long id);
    InsumoDto guardarInsumo(InsumoDto eventoDto);
    InsumoDto modificarInsumo(Long id, ModInsumoDto modInsumoDto);
    void eliminarInsumo(Long id);
}
