package org.flim.bufeteflim.dominio.exception;

public class EventoYaExisteException extends RuntimeException {
    public EventoYaExisteException(Long codigo) {
        super("El evento con código: "+codigo+" ya existe");
    }
}
