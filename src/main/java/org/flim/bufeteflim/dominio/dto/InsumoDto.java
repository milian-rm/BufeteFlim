package org.flim.bufeteflim.dominio.dto;

import jakarta.validation.constraints.NotBlank;
import org.springframework.boot.context.properties.bind.DefaultValue;

public record InsumoDto(
        Long codeSupply,
        @NotBlank(message = "La Descripción es obligatoria")
        String description,
        Long cuantity,
        Double unitaryCost,
        Double cost
) {
}
