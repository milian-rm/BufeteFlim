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

    public TimbreDto buscarPorNo(Long noTimbre){return this.timbreRepository.buscarPorNo(noTimbre);}

    public TimbreDto guardarTimbre(TimbreDto timbreDto){
        return this.timbreRepository.guardarTimbre(timbreDto);
    }

    public TimbreDto modificarTimbre(Long noTimbre, ModTimbreDto modTimbreDto){
        return this.timbreRepository.modificarTimbre(noTimbre, modTimbreDto);
    }

    public void eliminarTimbre(Long noTimbre){ this.timbreRepository.eliminarTimbre(noTimbre);}
}
