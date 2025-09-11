package org.flim.bufeteflim.dominio.exception;

public class ParteYaExisteException extends RuntimeException {
    public ParteYaExisteException(String dpi) {
        super("La Parte con el dpi: "+ dpi + " ya existe.");
    }
}
