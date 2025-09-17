package org.flim.bufeteflim.dominio.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import org.flim.bufeteflim.dominio.Gender;
import org.flim.bufeteflim.dominio.MaritalStatus;
import org.flim.bufeteflim.dominio.Role;

import java.time.LocalDate;

public record DetalleCasoDto (
         Long codeDetail,
         Long idComponent,
         Long idCase,
         @NotBlank(message = "El rol de la Parte en el Caso es obligatorio")
         String role
){

}