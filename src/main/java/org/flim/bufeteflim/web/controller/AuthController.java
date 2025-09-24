package org.flim.bufeteflim.web.controller;

import org.flim.bufeteflim.dominio.dto.LoginRequestDto;
import org.flim.bufeteflim.persistence.crud.CrudAbogadoEntity;
import org.flim.bufeteflim.persistence.entity.AbogadoEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {

    private final CrudAbogadoEntity crudAbogadoEntity;

    public AuthController(CrudAbogadoEntity crudAbogadoEntity) {
        this.crudAbogadoEntity = crudAbogadoEntity;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto loginRequest) {
        AbogadoEntity abogado = crudAbogadoEntity.findByCorreoAndPassword(loginRequest.email(), loginRequest.password());

        if (abogado != null) {
            return ResponseEntity.ok("Inicio de sesion exitoso.");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales invalidas.");
        }
    }
}