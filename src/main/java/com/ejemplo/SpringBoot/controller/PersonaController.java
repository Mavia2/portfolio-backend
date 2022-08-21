package com.ejemplo.SpringBoot.controller;

import com.ejemplo.SpringBoot.model.Persona;
import com.ejemplo.SpringBoot.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {
     @Autowired
    private IPersonaService persoServ;

        @PostMapping("/new/persona")
        public void agregarPersona(@RequestBody Persona pers){
        persoServ.crearPersona(pers);
        }

        @GetMapping("/get/persona")
        @ResponseBody 
        public List<Persona> verPersonas(){
        return  persoServ.verPersonas();
        }

        @GetMapping("/get/persona/{id}")
        @ResponseBody 
        public ResponseEntity<Persona> buscarPersona(@PathVariable Long id){
            Persona persona =  persoServ.buscarPersona(id);
            return new ResponseEntity(persona, HttpStatus.OK);
        }

        @DeleteMapping ("/delete/persona/{id}")
        public void borrarPersona(@PathVariable Long id){
        persoServ.borrarPersona(id);
        }

        @PutMapping ("/update/persona/{id}")
        public void modificarPersona(@PathVariable Long id, @RequestBody Persona persBody){
        Persona persona1 = persoServ.buscarPersona(id);
        if (persona1 != null ) {
            if(persBody.getNombre() != null)  persona1.setNombre(persBody.getNombre());
            if(persBody.getApellido()!= null)  persona1.setApellido(persBody.getApellido());
            if(persBody.getImagenPerfil() != null)  persona1.setImagenPerfil(persBody.getImagenPerfil());
            if(persBody.getImagenHeader()!= null)  persona1.setImagenHeader(persBody.getImagenHeader());
            if(persBody.getOcupacion()!= null)  persona1.setOcupacion(persBody.getOcupacion());
            if(persBody.getCiudad()!= null)  persona1.setCiudad(persBody.getCiudad());
            if(persBody.getPais()!= null)  persona1.setPais(persBody.getPais());
            if(persBody.getAcercaDe()!= null)  persona1.setAcercaDe(persBody.getAcercaDe());
            persoServ.crearPersona(persona1);
        }
    }
}
