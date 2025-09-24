package org.flim.bufeteflim.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.flim.bufeteflim.dominio.dto.GestionDto;
import org.flim.bufeteflim.dominio.dto.ModGestionDto;
import org.flim.bufeteflim.dominio.service.GestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/gestiones")
@Tag(name = "Gestiones", description = "Operaciones crud para Gestiones dentro BufeteFlim")
public class GestionController {
    private final GestionService gestionService;

    public GestionController(GestionService gestionService){
        this.gestionService = gestionService;
    }

    //Lista todas las gestiones
    @GetMapping
    public ResponseEntity<List<GestionDto>> obtenerTodo(){
        return ResponseEntity.ok(this.gestionService.obtenerTodo());
    }

    //Busca una gestion por su id ingresado
    @GetMapping("{id}")
    @Operation(
            summary = "Obtener una gestion por su identificador",
            description = "Retorna la gestion que coincida con el identificador solicitado",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Gestion No Encontrada"),
                    @ApiResponse(responseCode = "404", description = "Gestion No Encontrada", content = @Content)
            }
    )
    public ResponseEntity<GestionDto> buscarPorId
            (@Parameter(description = "Identificador de la gestion a recuperar", example = "2")
             @PathVariable Long id){
        return ResponseEntity.ok(this.gestionService.buscarPorId(id));
    }

    //Busca las gestion por su estado
    @GetMapping("estado/{estado}")
    @Operation(
            summary = "Obtener gestiones por su Estado",
            description = "Retorna las gestiones que coincida con el Estado solicitado",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Gestion No Encontrada"),
                    @ApiResponse(responseCode = "404", description = "Gestion No Encontrada", content = @Content)
            }
    )
    public ResponseEntity<List<GestionDto>> buscarPorEstado
    (@Parameter(description = "Estado de la gestion a recuperar", example = "COMPLETADA")
     @PathVariable String estado){
        return ResponseEntity.ok(this.gestionService.buscarPorEstado(estado));
    }

    //Crea o añade la gestion
    @PostMapping
    public ResponseEntity<GestionDto> guardarGestion
            (@RequestBody @Valid GestionDto gestionDto){
        return ResponseEntity.status(HttpStatus.CREATED).
                body(this.gestionService.guardarGestion(gestionDto));
    }

    //Modifica una gestion
    @PutMapping("{id}")
    public ResponseEntity<GestionDto> modificarGestion(@PathVariable Long id, @RequestBody ModGestionDto modGestionDto){
        return ResponseEntity.ok(this.gestionService.modificarGestion(id, modGestionDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> eliminarGestion(@PathVariable Long id){
        this.gestionService.eliminarGestion(id);
        return ResponseEntity.ok().build();
    }
}
