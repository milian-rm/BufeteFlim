package org.flim.bufeteflim.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "historiales")
@Data
public class HistorialEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHistorial;
    @Column(length = 250)
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "id_abogado", nullable = false)
    private AbogadoEntity idAbogado;
    @ManyToOne
    @JoinColumn(name = "id_caso", nullable = false)
    private CasoEntity idCaso;
}
