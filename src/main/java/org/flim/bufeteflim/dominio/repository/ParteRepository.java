package org.flim.bufeteflim.dominio.repository;

public interface ParteRepository {
    List<ParteDto> obtenerTodo();
    public ParteDto buscarPorCodigo(Long codigo);
    ParteDto guardarParte(ParteDto parteDto);
    ParteDto modificarParte(Long codigo, ModParteDto modParte);
    void eliminarParte(Long codigo);
}
