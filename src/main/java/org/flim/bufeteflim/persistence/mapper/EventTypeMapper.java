package org.flim.bufeteflim.persistence.mapper;


import org.flim.bufeteflim.dominio.EventType;
import org.mapstruct.Named;

public class EventTypeMapper {
    @Named("generarEventType")
    public static EventType generarEventType(String eventTypeString) {
        if (eventTypeString == null) return null;

        return switch (eventTypeString.toUpperCase()) {
            case "AUDIENCE" -> EventType.AUDIENCE;
            case "ORAL_DEBATE" -> EventType.ORAL_DEBATE;
            case "JUDICIAL_RECOGNITION" -> EventType.JUDICIAL_RECOGNITION;
            case "EVICTION" -> EventType.EVICTION;
            case "OTHER" -> EventType.OTHER;

            default -> null;
        };
    }

    @Named("generarTipoEvento")
    public static String generarTipoEvento(EventType eventType) {
        if (eventType == null) return null;

        return switch (eventType) {
            case AUDIENCE -> "AUDIENCE";
            case ORAL_DEBATE -> "ORAL_DEBATE";
            case JUDICIAL_RECOGNITION -> "JUDICIAL_RECOGNITION";
            case EVICTION -> "EVICTION";
            case OTHER -> "OTHER";
            default -> null;
        };
    }
}
