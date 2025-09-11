package org.flim.bufeteflim.dominio.exception;

public class ParteNoExisteException extends RuntimeException {
    public ParteNoExisteException (Long codigo){
        super("La Parte con código: "+codigo+" no existe en el sistema");
    }
}
