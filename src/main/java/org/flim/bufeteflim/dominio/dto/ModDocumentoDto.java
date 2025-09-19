package org.flim.bufeteflim.dominio.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.flim.bufeteflim.dominio.DocumentType;

public record ModDocumentoDto(
        @NotBlank(message = "El nombre del documento es obligatorio")
        String name,
        @NotNull(message = "El tipo de documento es obligatorio")
        DocumentType documentType,
        @NotNull(message = "El caso al que pertenece el documento es obligatorio")
        CasoDto casoDto
) {
}
