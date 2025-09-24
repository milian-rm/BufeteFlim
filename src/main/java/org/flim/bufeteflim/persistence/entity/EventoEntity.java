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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCaso", referencedColumnName = "idCaso")
    private CasoEntity caso;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAbogado", referencedColumnName = "idAbogado")
    private AbogadoEntity abogado;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idHistorial", referencedColumnName = "idHistorial")
    private HistorialEntity historial;
}
