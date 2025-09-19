package org.flim.bufeteflim.dominio.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import org.flim.bufeteflim.dominio.Status1;
import org.flim.bufeteflim.dominio.Type;

import java.time.LocalDate;

public record GestionDto(
    Long idManagement,
    @NotNull(message = "El tipo es obligatorio")
    Type type,
    @NotBlank(message = "La descripción es obligatoria")
    String description,
    @PastOrPresent(message = "La fecha de creación debe ser la presente o anterior")
    LocalDate creationDate,
    @FutureOrPresent(message = "La fecha de expiración debe ser futura a la presente")
    LocalDate expirationDate,
    @NotNull(message = "El estado es obligatorio")
    Status1 status1,
    @NotBlank(message = "Las observaciones son obligatorias")
    String observations,
    @NotNull(message = "El id del caso es obligatorio")
    Long idCase,
    @NotNull(message = "El id del abogado es obligatorio")
    Long idLawyer,
    @NotNull(message = "El id del historial es obligatorio")
    Long idRecord

){
}
