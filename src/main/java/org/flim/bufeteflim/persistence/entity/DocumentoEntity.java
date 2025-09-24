package org.flim.bufeteflim.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Documentos")
@Data
public class DocumentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDocumento;
    @Column(length = 150, unique = true, nullable = false)
    private String nombre;
    @Column(length = 40, nullable = false)
    private String tipoDocumento;
    @ManyToOne
    @JoinColumn(name = "idCaso", nullable = false)
    private CasoEntity caso;
}
