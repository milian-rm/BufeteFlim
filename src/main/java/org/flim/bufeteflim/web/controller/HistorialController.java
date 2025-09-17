package org.flim.bufeteflim.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.flim.bufeteflim.dominio.dto.HistorialDto;
import org.flim.bufeteflim.dominio.dto.ModHistorialDto;
import org.flim.bufeteflim.dominio.service.HistorialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/historiales")
@Tag(name = "Historiales", description = "Operaciones CRUD para Historiales dentor de Bufete Flim")
public class HistorialController {
    private final HistorialService historialService;

    @GetMapping
    public ResponseEntity<List<HistorialDto>> obtenerHistoriales(){
        return ResponseEntity.ok(historialService.obtenerTodo());
    }

    @GetMapping("/{idHistorial}")
    @Operation(
            summary = "Obtener un Historial por su identificador",
            description = "Retornar la parte que coincida con el identificador enviado",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Caso encontrado"),
                    @ApiResponse(responseCode = "404", description = "Caso no encontrado", content = @Content)
            }
    )
    public ResponseEntity<HistorialDto> buscarPorCodigo
            (@Parameter(description = "Identificar el Historial a recuperar", example = "1")
             @PathVariable Long id){
        return ResponseEntity.ok(this.historialService.buscarPorCodigo(id));
    }

    //Crear - agregar
    @PostMapping
    public ResponseEntity<HistorialDto> guardarHisotrial
    (@RequestBody @Valid HistorialDto historialDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.historialService.guardarHistorial(historialDto));
    }

    //Modificar
    @PutMapping("{idHistorial}")
    public  ResponseEntity<HistorialDto> modificarHistorial
    (@PathVariable Long id, @RequestBody ModHistorialDto modHistorialDto){
        return ResponseEntity.ok(this.historialService.modificarHistorial(id, modHistorialDto));
    }

    //Eliminar
    @DeleteMapping("{idHistorial}")
    public ResponseEntity<Void> eliminarHisotrial(@PathVariable Long id){
        this.historialService.eliminarHistorial(id);
        return ResponseEntity.ok().build();
    }
}
