
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
public class Persona implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "persona_generator")
    @SequenceGenerator(name="persona_generator", sequenceName = "persona_seq", allocationSize=1)
    @Column(name = "id", updatable = false, nullable = false)
    private Long  id;
    private String nombre;
    private String apellido;
    private String imagenPerfil ;
    private String imagenHeader;
    private String ocupacion;
    private String ciudad;
    private String pais;
    private String acercaDe;
   
    /* public Persona() {
    }

    public Persona(Long id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }
*/

    public Persona() {
    }

    public Persona(Long id, String nombre, String apellido, String imagenPerfil, String imagenHeader, String ocupacion, String ciudad, String pais, String acercaDe) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.imagenPerfil = imagenPerfil;
        this.imagenHeader = imagenHeader;
        this.ocupacion = ocupacion;
        this.ciudad = ciudad;
        this.pais = pais;
        this.acercaDe = acercaDe;
    }

    
    

   
    

    
    
    
}
