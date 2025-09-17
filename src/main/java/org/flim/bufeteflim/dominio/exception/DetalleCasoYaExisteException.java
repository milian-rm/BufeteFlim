package org.flim.bufeteflim.dominio.exception;

public class DetalleCasoYaExisteException extends RuntimeException {
    public DetalleCasoYaExisteException (Long codigo){
        super("El Detalle de caso con código: "+codigo+" ya existe en el sistema");
    }
}
