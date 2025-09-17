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
    @Column(length = 250, nullable = false)
    private String descripcion;
    @Column
    private Long idAbogado;
    @Column
    private Long idCaso;
}
