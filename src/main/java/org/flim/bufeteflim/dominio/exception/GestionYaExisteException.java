package org.flim.bufeteflim.dominio.exception;

public class GestionYaExisteException extends RuntimeException {
    public GestionYaExisteException(Long id)
    {
        super("La gestion con el id: "+ id + " Ya existe en el sistema");
    }
}
