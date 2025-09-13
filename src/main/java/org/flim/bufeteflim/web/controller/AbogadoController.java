package org.flim.bufeteflim.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.flim.bufeteflim.dominio.dto.AbogadoDto;
import org.flim.bufeteflim.dominio.dto.ModAbogadoDto;
import org.flim.bufeteflim.dominio.service.AbogadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/abogados")
@Tag(name = "Abogados", description = "Operaciones Crud para Abogados dentro de Bufete Flim")
public class AbogadoController {
    private final AbogadoService abogadoService;

    public AbogadoController(AbogadoService abogadoService){
        this.abogadoService = abogadoService;
    }

    //ResponseEntity que maneja las respuestas HTTP
    @GetMapping
    public ResponseEntity<List<AbogadoDto>> obtenerTodo(){
        //HTTP: 404: no se encontro,
        //      405: Metodo no permitido
        //      500: Error de logica de trabajo o interno
        //      200: ok
        return ResponseEntity.ok(this.abogadoService.obtenerTodo());
    }

    @GetMapping("{id}")
    @Operation(
            summary = "Obtener una parte por su identificador",
            description = "Retorna la parte que coincida con el identificador enviado",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Parte encontrada"),
                    @ApiResponse(responseCode = "404", description = "Parte no encontrada", content = @Content)
            }
    )
    public ResponseEntity<AbogadoDto> buscarPorId
            (@Parameter(description = "Identificador de la parte a recuperar", example = "3")
             @PathVariable Long id){
        return ResponseEntity.ok(this.abogadoService.buscarPorId(id));
    }

    //Crear - Agregar
    @PostMapping
    public ResponseEntity<AbogadoDto> guardarAbogado
    (@RequestBody @Valid AbogadoDto abogadoDto){
        //retornamos una respuesta de creacion de entidad

        return ResponseEntity.status(HttpStatus.CREATED).
                body(this.abogadoService.guardarAbogado(abogadoDto));
    }

    //Modificar
    @PutMapping("{id}")
    public ResponseEntity<AbogadoDto> modificarAbogado(@PathVariable Long id, @RequestBody ModAbogadoDto modAbogadoDto){
        return ResponseEntity.ok(this.abogadoService.modificarAbogado(id, modAbogadoDto));
    }

    //Eliminar
    @DeleteMapping("{id}")
    public ResponseEntity<Void> eliminarAbogado(@PathVariable Long id){
        this.abogadoService.eliminarAbogado(id);
        return ResponseEntity.ok().build();
    }
}
