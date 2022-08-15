
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

    public Educacion() {
    }

    public Educacion(Long id, String fotoUrl, String institucion, String titulo, String fechaInicio, String fechaFin, String lugar) {
        this.id = id;
        this.fotoUrl = fotoUrl;
        this.institucion = institucion;
        this.titulo = titulo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.lugar = lugar;
    }

}
