package org.flim.bufeteflim.dominio.exception;

public class CasoYaExisteExeption extends RuntimeException {
    public CasoYaExisteExeption(Long id) {
        super("El caso con id: " + id + " ya existe.");
    }
}
