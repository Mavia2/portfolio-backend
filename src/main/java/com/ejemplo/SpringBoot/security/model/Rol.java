
package com.ejemplo.SpringBoot.security.model;

import com.ejemplo.SpringBoot.security.enums.RolNombre;
import com.sun.istack.NotNull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_generator")
    @SequenceGenerator(name="usuario_generator", sequenceName = "usuario_seq", allocationSize=1)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private RolNombre rolnombre;

    public Rol() {
    }

    public Rol(RolNombre rolnombre) {
        this.rolnombre = rolnombre;
    }
    
    
    
}
