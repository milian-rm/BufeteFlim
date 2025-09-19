package org.flim.bufeteflim.persistence.mapper;

import org.flim.bufeteflim.dominio.Type;
import org.mapstruct.Named;

public class TypeMapper {

    @Named("generarType")
    public static Type generarType(String tipo){
        if (tipo == null) return null;

        return switch (tipo.toUpperCase()){
            case "DEMANDA" -> Type.DEMAND;
            case "QUERELLA" -> Type.COMPLAINT;
            case "ASESORIA" -> Type.ADVICE;
            case "ORIENTACIÓN" -> Type.GUIDANCE;
            case "MEMORIAL" -> Type.PLEADING;
            case "OTRO" -> Type.OTHER;
            default -> null;
        };
    }

    @Named("generarTipo")
    public static String generarTipo(Type type){
        if (type == null) return null;

        return switch (type){
            case Type.DEMAND -> "DEMANDA";
            case Type.COMPLAINT -> "QUERELLA";
            case Type.ADVICE -> "ASESORIA";
            case Type.GUIDANCE -> "ORIENTACIÓN";
            case Type.PLEADING -> "MEMORIAL";
            case Type.OTHER -> "OTRO";
            default -> null;
        };
    }
}
