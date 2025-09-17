package org.flim.bufeteflim.dominio.exception;

public class DetalleCasoNoExisteException extends RuntimeException {
    public DetalleCasoNoExisteException (Long codigo){
        super("El Detalle de Caso con código: "+codigo+" no existe en el sistema");
    }
}
