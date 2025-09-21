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
    @Column
    private Long idParte;
    @Column
    private Long idCaso;
    @Column(length = 20)
    private String rolEnCaso;
}
