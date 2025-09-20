package org.flim.bufeteflim.dominio.exception;

public class EventoNoExisteException extends RuntimeException {
    public EventoNoExisteException(Long codigo) {
        super("El evento con código: "+codigo+" no existe en el sistema");
    }
}
