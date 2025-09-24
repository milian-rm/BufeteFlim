package org.flim.bufeteflim.dominio.exception;

public class DocumentoYaExisteException extends RuntimeException {
    public DocumentoYaExisteException(String nombre) {
        super("El documento con el nombre: " + nombre + " ya existe");
    }
}
