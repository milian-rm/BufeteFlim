package org.flim.bufeteflim.dominio.exception;

public class TimbreNoExisteExeption extends RuntimeException {
    public TimbreNoExisteExeption(Long noRing) {
        super("El Timbre con No. :" + noRing + " no existe");
    }
}
