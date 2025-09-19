package org.flim.bufeteflim.dominio.exception;

public class GestionNoExisteException extends RuntimeException {
    public GestionNoExisteException(Long id) {

        super("La gestion con el codigo: " + id + " No existe en el sistema");
    }
}
