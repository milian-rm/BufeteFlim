package org.flim.bufeteflim.persistence.mapper;

import org.flim.bufeteflim.dominio.RingType;
import org.mapstruct.Named;

public class RingTypeMapper {

    @Named("generarRingType")
    public static RingType generarRingType(String ringTypeString){
        if (ringTypeString == null) return null;

        return switch (ringTypeString.toUpperCase()){
            case "FORENSE" -> RingType.FORENSIC;
            case "NOTARIAL" -> RingType.NOTARIAL;
            case "FISCAL" -> RingType.FISCAL;
            default -> null;
        };
    }

    @Named("generarTipoTimbre")
    public static String generarTipoTimbre(RingType ringType){
        if (ringType == null) return null;

        return switch (ringType){
            case RingType.FORENSIC -> "FORENSE";
            case RingType.NOTARIAL -> "NOTARIAL";
            case RingType.FISCAL -> "FISCAL";
            default -> null;
        };
    }
}
