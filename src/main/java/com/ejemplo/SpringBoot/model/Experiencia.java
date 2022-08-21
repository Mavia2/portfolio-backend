package com.ejemplo.SpringBoot.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Experiencia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "experiencia_generator")
    @SequenceGenerator(name="experiencia_generator", sequenceName = "experiencia_seq", allocationSize=1)
    @Column(name = "id", updatable = false, nullable = false)

    private Long  id;
    private String fotoUrl;
    private String institucion;
    private String cargo ;
    private String descripcion;
    private String fechaInicio;
    private String fechaFin;
    private String lugar;
    @Column(name="id_persona", nullable = false)
    private Long  idPersona;
}
