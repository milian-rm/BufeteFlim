package org.flim.bufeteflim.persistence.mapper;


import org.flim.bufeteflim.dominio.EventType;
import org.mapstruct.Named;

public class EventTypeMapper {
    @Named("generarEventType")
    public static EventType generarEventType(String eventTypeString) {
        if (eventTypeString == null) return null;

        return switch (eventTypeString.toUpperCase()) {
            case "AUDIENCIA" -> EventType.AUDIENCE;
            case "DEBATE_ORAL" -> EventType.ORAL_DEBATE;
            case "RECONOCIMIENTO_JUDICIAL" -> EventType.JUDICIAL_RECOGNITION;
            case "DESALOJO" -> EventType.EVICTION;
            case "OTRO" -> EventType.OTHER;

            default -> null;
        };
    }

    @Named("generarTipoEvento")
    public static String generarTipoEvento(EventType eventType) {
        if (eventType == null) return null;

        return switch (eventType) {
            case AUDIENCE -> "AUDIENCIA";
            case ORAL_DEBATE -> "DEBATE_ORAL";
            case JUDICIAL_RECOGNITION -> "RECONOCIMIENTO_JUDICIAL";
            case EVICTION -> "DESALOJO";
            case OTHER -> "OTRO";
            default -> null;
        };
    }
}
