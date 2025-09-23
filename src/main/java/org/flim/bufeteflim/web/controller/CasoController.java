package org.flim.bufeteflim.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.flim.bufeteflim.dominio.dto.CasoDto;
import org.flim.bufeteflim.dominio.dto.ModCasoDto;
import org.flim.bufeteflim.dominio.service.CasoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/casos")
@Tag(name = "Casos", description = "Operaciones Crud para Casos dentro de Bufete Flim")
public class CasoController {
    private final CasoService casoService;

    public CasoController(CasoService casoService){
        this.casoService = casoService;
    }

    @GetMapping
    public ResponseEntity<List<CasoDto>> obtenerCasos(){
        return ResponseEntity.ok(casoService.obtenerTodo());
    }

    @GetMapping("/{idCaso}")
    @Operation(
            summary = "Obtener un Caso por su identificador",
            description = "Retorna la parte que coincida con el identificador enviado",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Caso encontrado"),
                    @ApiResponse(responseCode = "404", description = "Caso no encontrado", content = @Content)
            }
    )
    public ResponseEntity<CasoDto> buscarPorId
            (@Parameter(description = "Identificador del Caso a recuperar", example = "1")
             @PathVariable Long idCaso){
        return ResponseEntity.ok(this.casoService.buscarPorId(idCaso));
    }

    //Buscar Casos por sus estados
    @GetMapping("estado/{estado}")
    @Operation(
            summary = "Obtener un Caso por su estado",
            description = "Retorna los Casos que coincidan con el estado enviado",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Caso encontrado"),
                    @ApiResponse(responseCode = "404", description = "Caso no encontrado", content = @Content)
            }
    )
    public ResponseEntity<List<CasoDto>> buscarPorEstado
            (@Parameter(description = "Estado del Caso a recuperar", example = "Suspendido")
             @PathVariable String estado){
        return ResponseEntity.ok(this.casoService.buscarPorEstado(estado));
    }

    //Crear - agregar
    @PostMapping
    public ResponseEntity<CasoDto> guardarCaso
    (@RequestBody @Valid CasoDto casoDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.casoService.guardarCaso(casoDto));
    }

    //modificar
    @PutMapping("{idCaso}")
    public ResponseEntity<CasoDto> modificarCaso
    (@PathVariable Long idCaso, @RequestBody ModCasoDto modCasoDto){
        return ResponseEntity.ok(this.casoService.modificarCaso(idCaso, modCasoDto));
    }

    //eliminar
    @DeleteMapping("{idCaso}")
    public ResponseEntity<Void> eliminarCaso(@PathVariable Long idCaso){
        this.casoService.eliminarCaso(idCaso);
        return ResponseEntity.ok().build();
    }
}