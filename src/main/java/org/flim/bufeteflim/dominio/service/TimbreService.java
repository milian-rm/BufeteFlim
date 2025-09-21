package org.flim.bufeteflim.dominio.service;

import org.flim.bufeteflim.dominio.dto.ModTimbreDto;
import org.flim.bufeteflim.dominio.dto.TimbreDto;
import org.flim.bufeteflim.dominio.repository.TimbreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimbreService {
    private final TimbreRepository timbreRepository;

    public TimbreService(TimbreRepository timbreRepository) {this.timbreRepository = timbreRepository;}

    public List<TimbreDto> obtenerTodo(){ return this.timbreRepository.obtenerTodo();}

    public TimbreDto buscarPorNo(Long noRing){return this.timbreRepository.buscarPorNo(noRing);}

    public TimbreDto guardarTimbre(TimbreDto timbreDto){
        return this.timbreRepository.guardarTimbre(timbreDto);
    }

    public TimbreDto modificarTimbre(Long noRing, ModTimbreDto modTimbreDto){
        return this.timbreRepository.modificarTimbre(noRing, modTimbreDto);
    }

    public void eliminarTimbre(Long noRing){ this.timbreRepository.eliminarTimbre(noRing);}
}
