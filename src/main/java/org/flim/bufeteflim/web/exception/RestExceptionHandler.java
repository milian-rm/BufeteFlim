package org.flim.bufeteflim.web.exception;

import org.flim.bufeteflim.dominio.exception.*;
import org.flim.bufeteflim.dominio.exception.Error;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(ParteYaExisteException.class)
    public ResponseEntity<Error> handleException(ParteYaExisteException ex){
        Error error = new Error("parte-ya-existe", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(ParteNoExisteException.class)
    public ResponseEntity<Error> handleException(ParteNoExisteException ex){
        Error error = new Error("parte-no-existe", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    //Detalle Caso
    @ExceptionHandler(DetalleCasoYaExisteException.class)
    public ResponseEntity<Error> handleExceptionDetalleCaso(ParteYaExisteException ex){
        Error error = new Error("detalle-caso-ya-existe", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(DetalleCasoNoExisteException.class)
    public ResponseEntity<Error> handleExceptionDetalleCaso(ParteNoExisteException ex){
        Error error = new Error("detalle-caso-no-existe", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(AbogadoYaExisteException.class)
    public ResponseEntity<Error> handleException(AbogadoYaExisteException ex){
        Error error = new Error("abogado-ya-existe", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(AbogadoNoExisteException.class)
    public ResponseEntity<Error> handleException(AbogadoNoExisteException ex){
        Error error = new Error("abogado-no-existe", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(CasoYaExisteException.class)
    public ResponseEntity<Error> handleException(CasoYaExisteException ex){
        Error error = new Error("caso-ya-existe", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(CasoNoExisteExeption.class)
    public ResponseEntity<Error> handleException(CasoNoExisteExeption ex){
        Error error = new Error("caso-no-existe", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(GestionYaExisteException.class)
    public ResponseEntity<Error> handleException(GestionYaExisteException ex){
        Error error = new Error("gestion-ya-existe", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(GestionNoExisteException.class)
    public ResponseEntity<Error> handleException(GestionNoExisteException ex){
        Error error = new Error("gestion-no-existe", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(DocumentoYaExisteException.class)
    public ResponseEntity<Error> handleException(DocumentoYaExisteException ex){
        Error error = new Error("documento-ya-existe", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(DocumentoNoExisteException.class)
    public ResponseEntity<Error> handleException(DocumentoNoExisteException ex){
        Error error = new Error("documento-no-existe", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler
    public ResponseEntity<List<Error>> handleException(MethodArgumentNotValidException ex){
        List<Error> errors = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(fieldError -> {
            errors.add(new Error(fieldError.getField(), fieldError.getDefaultMessage()));
        });
        return ResponseEntity.badRequest().body(errors);
    }

    //Manejador de errores predeteminado y desconocidos
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleException(Exception ex){
        Error error = new Error("error-desconocido", ex.getMessage());
        return ResponseEntity.internalServerError().body(error);
    }
}
