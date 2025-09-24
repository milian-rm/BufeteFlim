package org.flim.bufeteflim.dominio.dto;

import jakarta.validation.constraints.NotNull;
import org.flim.bufeteflim.dominio.Status1;
import org.flim.bufeteflim.dominio.Type;

import java.time.LocalDate;

public record ModGestionDto(

        Type type,
        String description,
        LocalDate creationDate,
        LocalDate expirationDate,
        Status1 status1,
        String observations,
        @NotNull(message = "El caso es obligatorio")
        CasoDto caso,
        @NotNull(message = "El abogado es obligatorio")
        AbogadoDto abogado,
        @NotNull(message = "El historial es obligatorio")
        HistorialDto historial
) {
}