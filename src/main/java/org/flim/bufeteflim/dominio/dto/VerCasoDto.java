package org.flim.bufeteflim.dominio.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import org.flim.bufeteflim.dominio.CaseType;
import org.flim.bufeteflim.dominio.Status;

import java.time.LocalDate;

public record VerCasoDto(
        Long idCaso,
        String title
) {
}
