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

    // Relación con Abogado
    @ManyToOne
    @JoinColumn(name = "id_abogado", nullable = false)
    private AbogadoEntity abogado;

    // Relación con Caso
    @ManyToOne
    @JoinColumn(name = "id_caso", nullable = false)
    private CasoEntity caso;

    // Relación con Historial
    @ManyToOne
    @JoinColumn(name = "id_historial", nullable = false)
    private HistorialEntity historial;
}
