package org.flim.bufeteflim.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "timbres")
@Data
public class TimbreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noTimbre;

    @Column(length = 10, nullable = false)
    private String tipo;

    //Llave foranea
    @Column
    private Long idAbogado;
}
