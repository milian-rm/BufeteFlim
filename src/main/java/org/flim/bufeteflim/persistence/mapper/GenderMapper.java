package org.flim.bufeteflim.persistence.mapper;

import org.flim.bufeteflim.dominio.Gender;
import org.mapstruct.Named;

public class GenderMapper {
    @Named("generarGender")
    public static Gender generarGender(String genero){
        if (genero == null) return null;

        return switch (genero.toUpperCase()){
            case "Masculino" -> Gender.MALE;
            case "Femenino" -> Gender.FEMALE;
            default -> null;
        };
    }

    @Named("generarGenero")
    public static String generarGenero(Gender genre){
        if (genre==null) return null;

        return switch (genre){
            case Gender.MALE -> "Masculino";
            case Gender.FEMALE -> "Femenino";
            default -> null;
        };
    }
}
