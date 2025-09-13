package org.flim.bufeteflim.persistence.mapper;

import org.flim.bufeteflim.dominio.Status;
import org.mapstruct.Named;

public class StatusMapper {
    @Named("generarStatus")
    public static Status gnerarStatus(String estado){
        if (estado == null) return null;
        return  switch (estado.toUpperCase()){
            case "EN_PROCESO" -> Status.IN_PROCESS;
            case "FINALIZADO" -> Status.COMPLETED;
            case "ARCHIVADO" -> Status.ARCHIVED;
            case "SUSPENDIDO" -> Status.SUSPENDED;
            default -> null;
        };
    }

    @Named("generarEstado")
    public static String generarEstado(Status status){
        if (status == null) return null;

        return switch (status){
            case Status.IN_PROCESS -> "EN_PROCESO";
            case Status.COMPLETED -> "FINALIZADO";
            case Status.ARCHIVED -> "ARCHIVADO";
            case Status.SUSPENDED -> "SUSPENDIDO";
            default -> null;
        };
    }
}
