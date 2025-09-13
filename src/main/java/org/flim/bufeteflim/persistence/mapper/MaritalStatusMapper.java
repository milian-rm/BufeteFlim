package org.flim.bufeteflim.persistence.mapper;

import org.flim.bufeteflim.dominio.MaritalStatus;
import org.mapstruct.Named;

public class MaritalStatusMapper {
    @Named("generarMaritalStatus")
    public static MaritalStatus generarMaritalStatus(String estado){
        if (estado == null) return null;

        return switch (estado.toUpperCase()){
            case "Soltero/a" -> MaritalStatus.SINGLE;
            case "Casado/a" -> MaritalStatus.MARRIED;
            case "Viudo/a" -> MaritalStatus.WIDOWED;
            case "Divorciado/a" -> MaritalStatus.DIVORCED;
            case "Union de Hecho" -> MaritalStatus.COHABITING_COUPLE;
            default -> null;
        };
    }

    @Named("generarEstadoCivil")
    public static String generarEstadoCivil(MaritalStatus maritalStatus){
        if (maritalStatus==null) return null;

        return switch (maritalStatus){
            case MaritalStatus.SINGLE -> "Soltero/a";
            case MaritalStatus.MARRIED -> "Casado/a";
            case MaritalStatus.WIDOWED -> "Viudo/a";
            case MaritalStatus.DIVORCED -> "Divorciado/a";
            case MaritalStatus.COHABITING_COUPLE -> "Union de Hecho";
            default -> null;
        };
    }
}
