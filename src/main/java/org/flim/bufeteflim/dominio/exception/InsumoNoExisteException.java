package org.flim.bufeteflim.dominio.exception;

public class InsumoNoExisteException extends RuntimeException {
    public InsumoNoExisteException(Long codigo) {
        super("El Insumo con código: "+codigo+" no existe en el Sistema");
    }
}
