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
    public ResponseEntity<Error> handleExceptionParte(ParteYaExisteException ex){
        Error error = new Error("parte-ya-existe", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(ParteNoExisteException.class)
    public ResponseEntity<Error> handleExceptionParte(ParteNoExisteException ex){
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
