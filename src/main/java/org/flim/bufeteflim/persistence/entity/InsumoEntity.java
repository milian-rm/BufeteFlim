package org.flim.bufeteflim.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "insumos")
@Data
public class InsumoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    @Column(unique = true, nullable = false)
    private String descripcion;
    @Column
    private Long cantidad;
    @Column
    private BigDecimal costoUnitario;
    @Column
    private BigDecimal costo;
}
