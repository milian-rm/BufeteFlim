package org.flim.bufeteflim.web.controller;


import dev.langchain4j.service.V;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.flim.bufeteflim.dominio.dto.DetalleCasoDto;
import org.flim.bufeteflim.dominio.dto.ModCasoDto;
import org.flim.bufeteflim.dominio.dto.ModDetalleCasoDto;
import org.flim.bufeteflim.dominio.service.DetalleCasoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/detallescasos")
@Tag(name = "DetallesCasos", description = "Operaciones Crud para DetallesCasos dentro de BufeteFlim")
public class DetalleCasoController {
    private final DetalleCasoService detalleCasoService;

    public DetalleCasoController(DetalleCasoService detalleCasoService){this.detalleCasoService = detalleCasoService;}

    @GetMapping
    public ResponseEntity<List<DetalleCasoDto>> obtenerDetalleCasos(){
        return ResponseEntity.ok(this.detalleCasoService.obtenerTodo());
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
    public ResponseEntity<DetalleCasoDto> buscarPorCodigo
            (@Parameter(description = "Identificador de la parte a recuperar" , example = "3")
             @PathVariable Long id){
        return ResponseEntity.ok(this.detalleCasoService.buscarPorCodigo(id));
    }

    //Crear - Agregar
    @PostMapping
    public ResponseEntity<DetalleCasoDto> guardarDetalleCaso
    (@RequestBody @Valid DetalleCasoDto detalleCasoDto){
        //Retornar una respuesta de creacion de entidad
        return ResponseEntity.status(HttpStatus.CREATED).body(this.detalleCasoService.guardarDetalleCaso(detalleCasoDto));
    }

    //Modificar
    @PutMapping("{codigo}")
    public ResponseEntity<DetalleCasoDto> modificarDetalleCaso
    (@PathVariable Long id, @RequestBody ModDetalleCasoDto modDetalleCasoDto){
        return ResponseEntity.ok(this.detalleCasoService.modificarDetalleCaso(id, modDetalleCasoDto));
    }

    //Eliminar
    @DeleteMapping("{codigo}")
    public ResponseEntity<Void> eliminarDetalleCaso(@PathVariable Long id){
        this.detalleCasoService.eliminarDetalleCaso(id);
        return ResponseEntity.ok().build();
    }
}
