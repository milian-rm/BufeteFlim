package org.flim.bufeteflim.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

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
