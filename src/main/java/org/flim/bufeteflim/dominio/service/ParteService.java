package org.flim.bufeteflim.dominio.service;

import org.flim.bufeteflim.dominio.dto.ModParteDto;
import org.flim.bufeteflim.dominio.dto.ParteDto;
import org.flim.bufeteflim.dominio.repository.ParteRepository;

import java.util.List;

public class ParteService {
    public ParteService(ParteRepository parteRepository) {
        this.parteRepository = parteRepository;
    }

    public List<ParteDto> obtenerTodo(){
        return this.parteRepository.obtenerTodo();
    }

    public ParteDto buscarPorCodigo(Long codigo){
        return this.parteRepository.buscarPorCodigo(codigo);
    }

    public ParteDto guardarParte(ParteDto peliculaDto){
        return this.parteRepository.guardarPelicula(peliculaDto);
    }

    public ParteDto modificarParte(Long codigo, ModParteDto modParteDto){
        return this.parteRepository.modificarPelicula(codigo, modParteDto);
    }

    public void eliminarParte(Long codigo){
        this.parteRepository.eliminarPelicula(codigo);
    }
}
