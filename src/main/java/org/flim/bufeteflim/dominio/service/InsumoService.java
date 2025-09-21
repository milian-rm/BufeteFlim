package org.flim.bufeteflim.dominio.service;

import org.flim.bufeteflim.dominio.dto.InsumoDto;
import org.flim.bufeteflim.dominio.dto.ModInsumoDto;
import org.flim.bufeteflim.dominio.repository.InsumoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsumoService {
    private final InsumoRepository insumoRepository;

    public InsumoService(InsumoRepository insumoRepository) {
        this.insumoRepository = insumoRepository;
    }

    public List<InsumoDto> obtenerTodo() {
        return this.insumoRepository.obtenerTodo();
    }

    public InsumoDto buscarPorCodigo(Long id){
        return this.insumoRepository.buscarPorCodigo(id);
    }

    public InsumoDto guardarInsumo(InsumoDto insumoDto) {
        Double costo = insumoDto.unitaryCost()*insumoDto.cuantity();


        return this.insumoRepository.guardarInsumo(insumoDto);
    }

    public InsumoDto modificarInsumo(Long id, ModInsumoDto modInsumoDto) {
        return this.insumoRepository.modificarInsumo(id, modInsumoDto);
    }

    public void eliminarInsumo(Long id) {
        this.insumoRepository.eliminarInsumo(id);
    }
}
