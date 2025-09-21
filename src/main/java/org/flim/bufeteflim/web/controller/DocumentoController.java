package org.flim.bufeteflim.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.flim.bufeteflim.dominio.dto.DocumentoDto;
import org.flim.bufeteflim.dominio.dto.ModCasoDto;
import org.flim.bufeteflim.dominio.dto.ModDocumentoDto;
import org.flim.bufeteflim.dominio.service.DocumentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/documentos")
@Tag(name = "Documentos", description = "Operaciones Crud para Documentos dentro de Bufete Flim")
public class DocumentoController {
    private final DocumentoService documentoService;

    public DocumentoController(DocumentoService documentoService){
        this.documentoService = documentoService;
    }

    @GetMapping
    public ResponseEntity<List<DocumentoDto>> obtenerDocumentos(){
        return ResponseEntity.ok(documentoService.obtenerTodo());
    }

    @GetMapping("{idDocumento}")
    @Operation(
            summary = "Obtener un Documento por su identificador",
            description = "Retornar la parte que coincida con el identificador enviado",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Documento encontrado"),
                    @ApiResponse(responseCode = "400", description = "Documento no encontrado", content = @Content)
            }
    )
    public ResponseEntity<DocumentoDto> buscarPorId
            (@Parameter(description = "Identificador del Documento a recuperar", example = "23")
             @PathVariable Long idDocumento){
        return ResponseEntity.ok(this.documentoService.buscarPorIdDocumento(idDocumento));
    }

    @PostMapping
    public ResponseEntity<DocumentoDto> guardarDocumento
            (@RequestBody @Valid DocumentoDto documentoDto){
        return  ResponseEntity.status(HttpStatus.CREATED).body(this.documentoService.guardarDocumento(documentoDto));
    }

    @PutMapping("{idDocumento}")
    public ResponseEntity<DocumentoDto> modificarDocumento
            (@PathVariable Long idDocumento, @RequestBody ModDocumentoDto modCasoDto){
        return ResponseEntity.ok(this.documentoService.modificarDocumento(idDocumento, modCasoDto));
    }

    @DeleteMapping("{idDocumento}")
    public ResponseEntity<Void> eliminarDocumento(@PathVariable Long idDocumento){
        this.documentoService.eliminarDocumento(idDocumento);
        return ResponseEntity.ok().build();
    }
}
