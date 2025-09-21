package org.flim.bufeteflim.dominio.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record ModHistorialDto(
        Long code,
        String description,
        AbogadoDto idLawyer,
        CasoDto idCase
) {
}
