package org.flim.bufeteflim.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "detalles_caso")
@Data
public class DetalleCasoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    @ManyToOne
    @JoinColumn(name = "id_parte", nullable = false)
    private ParteEntity parte;
    @ManyToOne
    @JoinColumn(name = "id_caso", nullable = false)
    private CasoEntity caso;
    @Column(length = 20)
    private String rolEnCaso;
}
