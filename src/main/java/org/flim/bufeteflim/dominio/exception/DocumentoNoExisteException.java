package org.flim.bufeteflim.dominio.exception;

public class DocumentoNoExisteException extends RuntimeException {
    public DocumentoNoExisteException(Long id) {
        super("El documento con el id: " + id + " no existe");
    }
}
