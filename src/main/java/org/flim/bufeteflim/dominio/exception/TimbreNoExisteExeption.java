package org.flim.bufeteflim.dominio.exception;

public class TimbreNoExisteExeption extends RuntimeException {
    public TimbreNoExisteExeption(Long noTimbre) {
        super("El Timbre con No. :" + noTimbre + " no existe");
    }
}
