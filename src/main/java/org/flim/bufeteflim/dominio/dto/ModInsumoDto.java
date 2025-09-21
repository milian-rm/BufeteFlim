package org.flim.bufeteflim.dominio.dto;

import jakarta.validation.constraints.NotBlank;

public record ModInsumoDto(
        Long codeSupply,
        @NotBlank(message = "La Descripción es obligatoria")
        String description,
        Long cuantity,
        Double unitaryCost,
        Double cost
) {
}
