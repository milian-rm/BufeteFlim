package org.flim.bufeteflim.dominio.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record ModCasoDto(
        @NotBlank(message = "El titulo es obligatorio")
        String title,
        @NotBlank(message = "La descripcion es obligatoria")
        String description,
        @PastOrPresent(message = "La fecha de inicio debe ser anterior o igual a la fecha actual")
        LocalDate startDate,
        @FutureOrPresent(message = "La fecha de cierre debe ser en el futuro o en el dia actual")
        LocalDate closingDate,
        @NotBlank(message = "El estado del caso es obligatorio")
        String status,
        @NotBlank(message = "El tipo de caso es obligatorio")
        String caseType
) {
}
