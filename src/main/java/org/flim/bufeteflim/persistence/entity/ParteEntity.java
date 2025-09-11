package org.flim.bufeteflim.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "partes")
@Data
public class ParteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    @Column(length = 100, nullable = false)
    private String nombre;
    @Column(length = 100, nullable = false)
    private String apellido;
    @Column(length = 16)
    private String dpi;
    @Column(length = 20)
    private String estadoCivil;
    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;
    @Column(length = 32)
    private String oficio;
    @Column(length = 20)
    private String sexo;
    @Column
    private String lugarNacimiento;
    @Column(length = 32)
    private String etnia;
    @Column
    private String domicilio;
    @Column(length = 32)
    private String telefono;
    @Column(length = 32)
    private String nit;
    @Column(length = 20)
    private String rol;

}