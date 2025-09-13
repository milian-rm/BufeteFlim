package org.flim.bufeteflim.dominio.service;

import java.util.List;

import org.flim.bufeteflim.dominio.dto.AbogadoDto;
import org.flim.bufeteflim.dominio.dto.ModAbogadoDto;
import org.flim.bufeteflim.dominio.repository.AbogadoRepository;
import org.springframework.stereotype.Service;

@Service
public class AbogadoService {
    private final AbogadoRepository abogadoRepository;

    public AbogadoService(AbogadoRepository abogadoRepository){
        this.abogadoRepository = abogadoRepository;
    }

    public List<AbogadoDto> obtenerTodo(){
        return this.abogadoRepository.obtenerTodo();
    }

    public AbogadoDto buscarPorId(Long id){
        return this.abogadoRepository.buscarPorId(id);
    }

    public AbogadoDto guardarAbogado(AbogadoDto abogadoDto){
        return this.abogadoRepository.guardarAbogado(abogadoDto);
    }

    public AbogadoDto modificarAbogado(Long id, ModAbogadoDto modAbogadoDto){
        return this.abogadoRepository.modificarAbogado(id, modAbogadoDto);
    }

    public void eliminarAbogado(Long id){
        this.abogadoRepository.eliminarAbogado(id);
    }
}
