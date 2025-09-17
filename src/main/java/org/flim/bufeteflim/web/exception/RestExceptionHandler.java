package org.flim.bufeteflim.web.exception;

import org.flim.bufeteflim.dominio.exception.*;
import org.flim.bufeteflim.dominio.exception.Error;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

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
