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
}
