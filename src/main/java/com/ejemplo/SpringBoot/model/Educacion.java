
package com.ejemplo.SpringBoot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class Educacion implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "educacion_generator")
    @SequenceGenerator(name="educacion_generator", sequenceName = "educacion_seq", allocationSize=1)
    @Column(name = "id", updatable = false, nullable = false)
    
    private Long  id;
    private String fotoUrl;
    private String institucion;
    private String titulo ;
    private String fechaInicio;
    private String fechaFin;
    private String lugar;
    @Column(name="id_persona", nullable = false)
    private Long  idPersona;
    
    

    

}
