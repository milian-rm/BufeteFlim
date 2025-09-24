package org.flim.bufeteflim.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.validation.Valid;
import lombok.Data;
import org.flim.bufeteflim.dominio.dto.AbogadoDto;
import org.flim.bufeteflim.dominio.dto.GestionDto;
import org.flim.bufeteflim.dominio.dto.ModAbogadoDto;
import org.flim.bufeteflim.dominio.repository.AbogadoRepository;
import org.flim.bufeteflim.dominio.service.AbogadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@Component
@ViewScoped
@Data
@RestController
@RequestMapping("/v1/abogados")
@Tag(name = "Abogados", description = "Operaciones Crud para Abogados dentro de Bufete Flim")
public class AbogadoController {
    private final AbogadoService abogadoRepository;

    public AbogadoController(AbogadoService abogadoRepository){
        this.abogadoRepository = abogadoRepository;



    }

    //ResponseEntity que maneja las respuestas HTTP
    @GetMapping
    public ResponseEntity<List<AbogadoDto>> obtenerTodo(){
        //HTTP: 404: no se encontro,
        //      405: Metodo no permitido
        //      500: Error de logica de trabajo o interno
        //      200: ok
        return ResponseEntity.ok(this.abogadoRepository.obtenerTodo());
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
        return ResponseEntity.ok(this.abogadoRepository.buscarPorId(id));
    }

    //Busca el abogado por su nombre
    @GetMapping("nombre/{nombre}")
    @Operation(
            summary = "Obtener un abogado por su Nombre",
            description = "Retorna el abogado que coincida con el Nombre solicitado",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Abogado No Encontrada"),
                    @ApiResponse(responseCode = "404", description = "Abogado No Encontrada", content = @Content)
            }
    )
    public ResponseEntity<AbogadoDto> buscarPorNombre
    (@Parameter(description = "Nombre del abogado a recuperar", example = "Juan")
     @PathVariable String nombre){
        return ResponseEntity.ok(this.abogadoRepository.buscarPorNombre(nombre));
    }

    //Crear - Agregar
    @PostMapping
    public ResponseEntity<AbogadoDto> guardarAbogado
    (@RequestBody @Valid AbogadoDto abogadoDto){
        //retornamos una respuesta de creacion de entidad

        return ResponseEntity.status(HttpStatus.CREATED).
                body(this.abogadoRepository.guardarAbogado(abogadoDto));
    }

    //Modificar
    @PutMapping("{id}")
    public ResponseEntity<AbogadoDto> modificarAbogado(@PathVariable Long id, @RequestBody ModAbogadoDto modAbogadoDto){
        return ResponseEntity.ok(this.abogadoRepository.modificarAbogado(id, modAbogadoDto));
    }

    //Eliminar
    @DeleteMapping("{id}")
    public ResponseEntity<Void> eliminarAbogado(@PathVariable Long id){
        this.abogadoRepository.eliminarAbogado(id);
        return ResponseEntity.ok().build();
    }
}
