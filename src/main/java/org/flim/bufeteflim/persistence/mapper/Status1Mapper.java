package org.flim.bufeteflim.persistence.mapper;

import org.flim.bufeteflim.dominio.Status1;
import org.mapstruct.Named;

public class Status1Mapper {

    @Named("generarStatus1")
    public static Status1 generarStatus1(String estado){
        if (estado == null) return null;
        return switch (estado.toUpperCase()){
            case "PENDIENTE" -> Status1.PENDING;
            case "COMPLETADA" -> Status1.COMPLETED;
            case "CANCELADA" -> Status1.CANCELED;
            default -> null;
        };
    }

    @Named("generarEstado1")
    public static String generarEstado1(Status1 status1){
        if (status1 == null) return null;
        return switch (status1){
            case Status1.PENDING -> "PENDIENTE";
            case Status1.COMPLETED -> "COMPLETADA";
            case Status1.CANCELED -> "CANCELADA";
            default -> null;
        };
    }
}
