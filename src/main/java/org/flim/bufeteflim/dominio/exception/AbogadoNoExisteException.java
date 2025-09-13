package org.flim.bufeteflim.dominio.exception;

public class AbogadoNoExisteException extends RuntimeException{
    public AbogadoNoExisteException(Long codigo){
        super("El abogado con código: " + codigo + " no existe en el sistema");
    }
}
