package org.flim.bufeteflim.dominio.exception;

public class CasoYaExisteException extends RuntimeException {
    public CasoYaExisteException(String titulo) {
        super("El caso con titulo: " + titulo + " ya existe.");
    }
}
