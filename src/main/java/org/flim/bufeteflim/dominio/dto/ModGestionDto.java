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
        @NotNull(message = "El id del caso es obligatorio")
        Long idCase,
        @NotNull(message = "El id del abogado es obligatorio")
        Long idLawyer,
        @NotNull(message = "El id del historial es obligatorio")
        Long idRecord
) {
}
