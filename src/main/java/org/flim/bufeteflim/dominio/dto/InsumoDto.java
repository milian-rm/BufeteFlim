package org.flim.bufeteflim.dominio.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.boot.context.properties.bind.DefaultValue;

public record InsumoDto(
        Long codeSupply,
        @NotBlank(message = "La Descripción es obligatoria")
        String description,
        Long cuantity,
        Double unitaryCost,
        Double cost
) {
    public InsumoDto(Long codeSupply, String description, Long cuantity, Double unitaryCost, Double cost) {
        this.codeSupply = codeSupply;
        this.description = description;
        this.cuantity = cuantity;
        this.unitaryCost = unitaryCost;
        this.cost = cuantity*unitaryCost;
    }
}
