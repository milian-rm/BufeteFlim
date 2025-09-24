package org.flim.bufeteflim.dominio.exception;

public class TimbreYaExisteException extends RuntimeException {
    public TimbreYaExisteException(Long noTimbre) {
        super("El timbre con el No. : " + noTimbre + " ya existe.");
    }
}
