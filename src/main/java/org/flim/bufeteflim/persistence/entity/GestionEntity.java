package org.flim.bufeteflim.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "gestiones")
@Data
public class GestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGestion;
    @Column(length = 200)
    private String tipo;
    @Column(length = 250)
    private String descripcion;
    @Column
    private LocalDate fechaCreacion;
    @Column
    private LocalDate fechaVencimiento;
    @Column(length = 150)
    private String estado;
    @Column(length = 250)
    private String observaciones;
    @Column(nullable = false)
    private Long idCaso;
    @Column(nullable = false)
    private Long idAbogado;
    @Column(nullable = false)
    private Long idHistorial;
}
