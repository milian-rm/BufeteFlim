package org.flim.bufeteflim.dominio.exception;

public class HistorialNoExisteException extends RuntimeException {
    public HistorialNoExisteException(Long id) {
        super("El historial con el id: " + id + " no existe en el sistema.");
    }
}
