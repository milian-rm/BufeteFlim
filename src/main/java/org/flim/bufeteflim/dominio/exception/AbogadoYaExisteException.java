package org.flim.bufeteflim.dominio.exception;

public class AbogadoYaExisteException extends RuntimeException {
    public AbogadoYaExisteException(String dpi) {
        super("El abogado con el dpi: "+ dpi + " ya existe.");
    }
}
