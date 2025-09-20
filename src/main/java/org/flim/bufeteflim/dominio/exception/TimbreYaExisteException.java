package org.flim.bufeteflim.dominio.exception;

public class TimbreYaExisteException extends RuntimeException {
    public TimbreYaExisteException(Long noRing) {
        super("El timbre con el No. : " + noRing + " ya existe.");
    }
}
