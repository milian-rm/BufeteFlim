package org.flim.bufeteflim.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.flim.bufeteflim.dominio.dto.EventoDto;
import org.flim.bufeteflim.dominio.dto.ModEventoDto;
import org.flim.bufeteflim.dominio.service.EventoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/eventos")
@Tag(name = "Eventos", description = "Operaciones Crud para Eventos dentro de BufeteFlim")
public class EventoController {

    private final EventoService eventoService;

    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @GetMapping
    public ResponseEntity<List<EventoDto>> obtenerEventos() {
        return ResponseEntity.ok(this.eventoService.obtenerTodo());
    }

    @GetMapping("{id}")
    @Operation(
            summary = "Obtener un Evento por su Identificador",
            description = "Retorna el evento que coincida con el identificador enviado",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Evento encontrado"),
                    @ApiResponse(responseCode = "404", description = "Evento no encontrado", content = @Content)
            }
    )
    public ResponseEntity<EventoDto> buscarPorCodigo
            (@Parameter(description = "Identificador del Evento a recuperar", example = "3")
             @PathVariable long id) {
        return ResponseEntity.ok(this.eventoService.buscarPorCodigo(id));
    }

    @PostMapping
    public ResponseEntity<EventoDto> guardarEvento
            (@RequestBody @Valid EventoDto eventoDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.eventoService.guardarEvento(eventoDto));
    }

    @PutMapping("{id}")
    public ResponseEntity<EventoDto> modificarEvento
            (@PathVariable long id, @RequestBody ModEventoDto modEventoDto) {
        return ResponseEntity.ok(this.eventoService.modificarEvento(id, modEventoDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> eliminarEvento(@PathVariable long id) {
        this.eventoService.eliminarEvento(id);
        return ResponseEntity.ok().build();
    }
}
