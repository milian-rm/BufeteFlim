package org.flim.bufeteflim.dominio.exception;

public class InsumoYaExisteException extends RuntimeException {
    public InsumoYaExisteException(Long codigo) {
        super("El Insumo con código: "+codigo+" ya existe");
    }
}
