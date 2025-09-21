package org.flim.bufeteflim.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "insumos")
@Data
public class InsumoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    @Column
    private String descripcion;
    @Column
    private Long cantidad;
    @Column
    private Double costoUnitario;
    @Column
    private Double costo;
}
