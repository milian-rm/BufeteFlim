package org.flim.bufeteflim.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.flim.bufeteflim.dominio.dto.InsumoDto;
import org.flim.bufeteflim.dominio.dto.ModInsumoDto;
import org.flim.bufeteflim.dominio.service.InsumoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/insumos")
@Tag(name = "Insumos", description = "Operaciones Crud para Insumos dentro de BufeteFlim")
public class InsumoController {
    private final InsumoService insumoService;

    public InsumoController(InsumoService insumoService) {
        this.insumoService = insumoService;
    }

    @GetMapping
    public ResponseEntity<List<InsumoDto>> obtenerInsumos() {
        return ResponseEntity.ok(this.insumoService.obtenerTodo());
    }

    @GetMapping("{id}")
    @Operation(
            summary = "Obtener un Insumo por su Identificador",
            description = "Retorna el insumo que coincida con el identificador enviado",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Insumo encontrado"),
                    @ApiResponse(responseCode = "404", description = "Insumo no encontrado", content = @Content)
            }
    )
    public ResponseEntity<InsumoDto> buscarPorCodigo
            (@Parameter(description = "Identificador del Insumo a recuperar", example = "3")
             @PathVariable long id) {
        return ResponseEntity.ok(this.insumoService.buscarPorCodigo(id));
    }

    @PostMapping
    public ResponseEntity<InsumoDto> guardarInsumo
            (@RequestBody @Valid InsumoDto insumoDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.insumoService.guardarInsumo(insumoDto));
    }

    @PutMapping("{id}")
    public ResponseEntity<InsumoDto> modificarInsumo
            (@PathVariable long id, @RequestBody ModInsumoDto modInsumoDto) {
        return ResponseEntity.ok(this.insumoService.modificarInsumo(id, modInsumoDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> eliminarInsumo(@PathVariable long id) {
        this.insumoService.eliminarInsumo(id);
        return ResponseEntity.ok().build();
    }
}
