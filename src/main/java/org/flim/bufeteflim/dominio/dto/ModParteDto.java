package org.flim.bufeteflim.dominio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import org.flim.bufeteflim.dominio.Gender;
import org.flim.bufeteflim.dominio.MaritalStatus;
import org.flim.bufeteflim.dominio.Role;

import java.time.LocalDate;

public record ModParteDto(
        @NotBlank(message = "El nombre es Obligatorio")
        String name,
        @NotBlank(message = "El Apellido es Obligatorio")
        String lastName,
        String dpi,
        MaritalStatus maritalStatus,
        @PastOrPresent(message = "La fecha de nacimiento debe ser anterior a la fecha actual")
        LocalDate birthdate,
        String job,
        Gender gender,
        String birthplace,
        String ethnicity,
        String address,
        String phoneNumber,
        String nit,
        Role role
) {
}
