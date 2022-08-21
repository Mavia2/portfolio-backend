
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
public class Proyecto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "proyecto_generator")
    @SequenceGenerator(name="proyecto_generator", sequenceName = "proyecto_seq", allocationSize=1)
    @Column(name = "id", updatable = false, nullable = false)
    
    private Long  id;
    private String titulo;
    private String descripcion;
    private String fechaRealizacion ;
    private String proyectoUrl;
    @Column(name="id_persona", nullable = false)
    private Long  idPersona;
    
}
