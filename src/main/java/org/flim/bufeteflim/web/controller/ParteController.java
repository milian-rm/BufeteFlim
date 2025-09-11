package org.flim.bufeteflim.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.flim.bufeteflim.dominio.dto.ModParteDto;
import org.flim.bufeteflim.dominio.dto.ParteDto;
import org.flim.bufeteflim.dominio.service.ParteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/partes")
@Tag(name = "Partes", description = "Operaciones Crud para Partes dentro de Quimvana")
public class ParteController {
    private final ParteService parteService;

    public ParteController(ParteService parteService) {
        this.parteService = parteService;
    }

    //ResponseEntity: manejar las respuestas HTTP
    @GetMapping
    public ResponseEntity<List<ParteDto>> obtenerPartes() {
        //HTTP: 404: no se encontro,
        //      405: Metodo no permitido
        //      500: Error de logica de trabajo o interno
        //      200: ok
        return ResponseEntity.ok(this.parteService.obtenerTodo());
    }

    @GetMapping("{codigo}")
    @Operation(
            summary = "Obtener una parte por su identificador",
            description = "Retorna la parte que coincida con el identificador enviado",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Parte encontrada"),
                    @ApiResponse(responseCode = "404", description = "Parte no encontrada", content = @Content)
            }
    )
    public ResponseEntity<ParteDto> buscarPorCodigo
            (@Parameter(description = "Identifcador de la parte a recuperar" , example = "3")
             @PathVariable Long codigo) {
        return ResponseEntity.ok(this.parteService.buscarPorCodigo(codigo));
    }


    //crear - agregar
    @PostMapping
    public ResponseEntity<ParteDto> guardarParte
    (@RequestBody @Valid ParteDto parteDto) {

        //retornar una respuesta de creacion de entidad

        return ResponseEntity.status(HttpStatus.CREATED).
                body(this.parteService.guardarParte(parteDto));
    }


    //modificar
    @PutMapping("{codigo}")
    public ResponseEntity<ParteDto> modificarParte(@PathVariable Long codigo, @RequestBody ModParteDto modParte){
        return ResponseEntity.ok(this.parteService.modificarParte(codigo, modParte));
    }
    //eliminar
    @DeleteMapping("{codigo}")
    public ResponseEntity<Void> eliminarParte(@PathVariable Long codigo){
        this.parteService.eliminarParte(codigo);
        return ResponseEntity.ok().build();
    }
}
