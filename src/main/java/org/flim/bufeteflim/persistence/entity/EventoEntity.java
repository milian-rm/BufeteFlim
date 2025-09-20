package org.flim.bufeteflim.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "eventos")
@Data
public class EventoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    @Column(length = 50)
    private String tipo;
    @Column
    private Long idCaso;
    @Column
    private Long idAbogado;
    @Column
    private Long idHistorial;
}
