package org.flim.bufeteflim.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.flim.bufeteflim.dominio.dto.ModTimbreDto;
import org.flim.bufeteflim.dominio.dto.TimbreDto;
import org.flim.bufeteflim.dominio.service.TimbreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/timbres")
@Tag(name = "Timbres", description = "Operaciones Crud para Timbres dentro de Bufete Flim")
public class TimbreController {

    private final TimbreService timbreService;

    public TimbreController(TimbreService timbreService){this.timbreService = timbreService;}

    //Listar
    @GetMapping
    public ResponseEntity<List<TimbreDto>> obtenerTimbres(){
        return ResponseEntity.ok(this.timbreService.obtenerTodo());
    }

    //Buscar Por No.
    @GetMapping("{noTimbre}")
    @Operation(
            summary = "Obtener una parte por su identificador",
            description = "Retorna la parte que coincida con el identificador enviado",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Parte encontrada"),
                    @ApiResponse(responseCode = "404", description = "Parte no encontrada", content = @Content)
            }
    )
    public ResponseEntity<TimbreDto> buscarPorNo
            (@Parameter(description = "Identificar a la parte a recuperar" , example = "3")
             @PathVariable Long noTimbre){
        return ResponseEntity.ok(this.timbreService.buscarPorNo(noTimbre));
    }

    //Crear - Agregar
    @PostMapping
    public ResponseEntity<TimbreDto> guardarTimbre
    (@RequestBody @Valid TimbreDto timbreDto){
        return ResponseEntity.status(HttpStatus.CREATED).
                body(this.timbreService.guardarTimbre(timbreDto));
    }

    //Modificar
    @PutMapping("{noTimbre}")
    public ResponseEntity<TimbreDto> modificarTimbre
    (@PathVariable("noTimbre") Long noTimbre, @RequestBody ModTimbreDto modTimbreDto){
        return ResponseEntity.ok(this.timbreService.modificarTimbre(noTimbre, modTimbreDto));
    }

    //Eliminar
    @DeleteMapping("{noTimbre}")
    public ResponseEntity<Void> eliminarTimbre(@PathVariable Long noTimbre){
        this.timbreService.eliminarTimbre(noTimbre);
        return ResponseEntity.ok().build();
    }
}
