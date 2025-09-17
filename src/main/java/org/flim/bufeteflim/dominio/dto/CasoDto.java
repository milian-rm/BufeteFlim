package org.flim.bufeteflim.dominio.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import org.flim.bufeteflim.dominio.CaseType;
import org.flim.bufeteflim.dominio.Status;

import java.time.LocalDate;

public record CasoDto(
    Long idCaso,
    @NotBlank(message = "El titulo es obligatorio")
    String title,
    @NotBlank(message = "La descripcion es obligatoria")
    String description,
    @PastOrPresent(message = "La fecha de inicio debe ser anterior o igual a la fecha actual")
    LocalDate startDate,
    @FutureOrPresent(message = "La fecha de cierre debe ser en el futuro o en el dia actual")
    LocalDate closingDate,
    @NotNull(message = "El estado del caso es obligatorio")
    Status status,
    @NotNull(message = "El tipo de caso es obligatorio")
    CaseType caseType
) {
}
