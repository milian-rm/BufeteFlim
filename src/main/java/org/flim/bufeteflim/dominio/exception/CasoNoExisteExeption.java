package org.flim.bufeteflim.dominio.exception;

public class CasoNoExisteExeption extends RuntimeException {
    public CasoNoExisteExeption(Long id) {
        super("El caso con id: " + id + " no existe en el sistema.");
    }
}
