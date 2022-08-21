
package com.ejemplo.SpringBoot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
    @Column(name="id_persona", nullable = false)
    private Long  idPersona;

   
    @OneToOne
    private User user;
    
    @OneToMany
    @JoinColumn(name = "id_persona")
    private List<Educacion> educaciones;

    @OneToMany
    @JoinColumn(name = "id_persona")
    private List<Experiencia> experiencias;

    @OneToMany
    @JoinColumn(name = "id_persona")
    private List<Proyecto> proyectos;

    @OneToMany
    @JoinColumn(name = "id_persona")
    private List<Skill> skills;
    

    

    
}
