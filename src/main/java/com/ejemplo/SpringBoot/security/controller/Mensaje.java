
package com.ejemplo.SpringBoot.security.controller;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Mensaje implements Serializable{
    private String mensaje;
    
    
    //constructor vacio y lleno

    public Mensaje() {
    }

    public Mensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
    
    
}
