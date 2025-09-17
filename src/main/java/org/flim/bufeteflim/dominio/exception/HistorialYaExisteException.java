package org.flim.bufeteflim.dominio.exception;

public class HistorialYaExisteException extends RuntimeException {
    public HistorialYaExisteException(Long id) {
        super("El historial con id: " + id + " ya existe");
    }
}
