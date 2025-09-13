package org.flim.bufeteflim.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "abogados")
@Data
public class AbogadoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAbogado;

    @Column(length = 150, nullable = false)
    private String nombre;
    @Column(length = 150, nullable = false)
    private String apellido;
    @Column(length = 16, nullable = false)
    private String dpi;
    @Column(length = 12, nullable = false)
    private String noColegiadoActivo;
    @Column(length = 100, nullable = false)
    private String correo;
    @Column(length = 32, nullable = false)
    private String telefono;
    @Column(length = 150, nullable = false)
    private String specialty;

}
