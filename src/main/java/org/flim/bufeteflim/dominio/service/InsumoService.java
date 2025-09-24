package org.flim.bufeteflim.dominio.service;

import org.flim.bufeteflim.dominio.dto.InsumoDto;
import org.flim.bufeteflim.dominio.dto.ModInsumoDto;
import org.flim.bufeteflim.dominio.repository.InsumoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
        BigDecimal unitaryCost = insumoDto.unitaryCost();
        Long cuantity = insumoDto.cuantity();

        BigDecimal calculatedCost = BigDecimal.ZERO;
        if (unitaryCost != null && cuantity != null) {
            calculatedCost = unitaryCost.multiply(new BigDecimal(cuantity))
                    .setScale(2, RoundingMode.HALF_UP);
        }

        InsumoDto insumoConCostoCalculado = new InsumoDto(
                insumoDto.codeSupply(),
                insumoDto.description(),
                insumoDto.cuantity(),
                insumoDto.unitaryCost(),
                calculatedCost.doubleValue()
        );

        return this.insumoRepository.guardarInsumo(insumoConCostoCalculado);
    }

    public InsumoDto modificarInsumo(Long id, ModInsumoDto modInsumoDto) {
        return this.insumoRepository.modificarInsumo(id, modInsumoDto);
    }

    public void eliminarInsumo(Long id) {
        this.insumoRepository.eliminarInsumo(id);
    }
}
