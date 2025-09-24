package org.flim.bufeteflim.dominio.dto;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.math.RoundingMode;

public record InsumoDto(
        Long codeSupply,
        @NotBlank(message = "La Descripción es obligatoria")
        String description,
        Long cuantity,
        BigDecimal unitaryCost,
        double cost
) {
    public InsumoDto(Long codeSupply, String description, Long cuantity, BigDecimal unitaryCost, double cost) {
        this.codeSupply = codeSupply;
        this.description = description;
        this.cuantity = cuantity;
        this.unitaryCost = unitaryCost;
        if (cuantity != null && unitaryCost != null) {
            BigDecimal totalCost = unitaryCost.multiply(new BigDecimal(cuantity));
            // Correct the assignment by converting BigDecimal to a double
            this.cost = totalCost.setScale(2, RoundingMode.HALF_UP).doubleValue();
        } else {
            this.cost = 0.0;
        }
    }
}
