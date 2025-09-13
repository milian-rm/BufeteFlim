package org.flim.bufeteflim.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "Casos")
@Data
public class CasoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCaso;
    @Column(length = 150, unique = true, nullable = false)
    private String titulo;
    @Column(length = 1000, unique = true, nullable = false)
    private String descripcion;
    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;
    @Column(name = "fecha_cierre")
    private LocalDate fechaCierre;
    @Column(length = 20, nullable = false)
    private String estado;
    @Column(length = 40, nullable = false)
    private String tipoCaso;
}
