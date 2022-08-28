package com.ejemplo.SpringBoot.controller;

import com.ejemplo.SpringBoot.model.Persona;
import com.ejemplo.SpringBoot.security.controller.Mensaje;
import com.ejemplo.SpringBoot.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
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
    private IPersonaService personaService;

    @PostMapping("/new/persona")
    public ResponseEntity<?> agregarPersona(@RequestBody Persona persona) {
        if (!StringUtils.hasText(persona.getNombre())) {
            return new ResponseEntity("La nombre de la persona es obligatorio.", HttpStatus.BAD_REQUEST);
        }
        if (!StringUtils.hasText(persona.getApellido())) {
            return new ResponseEntity("El apellido es obligatorio.", HttpStatus.BAD_REQUEST);
        }
        if (!StringUtils.hasText(persona.getImagenPerfil())) {
            return new ResponseEntity("La imagen de perfil es obligatoria.", HttpStatus.BAD_REQUEST);
        }
        if (!StringUtils.hasText(persona.getImagenHeader())) {
            return new ResponseEntity("La imagen del header es obligatorio.", HttpStatus.BAD_REQUEST);
        }
        if (!StringUtils.hasText(persona.getOcupacion())) {
            return new ResponseEntity("La ocupacion es obligatoria.", HttpStatus.BAD_REQUEST);
        }
        if (!StringUtils.hasText(persona.getCiudad())) {
            return new ResponseEntity("La ciudad es obligatoria.", HttpStatus.BAD_REQUEST);
        }
        if (!StringUtils.hasText(persona.getPais())) {
            return new ResponseEntity("El pais es obligatorio.", HttpStatus.BAD_REQUEST);
        }
        if (!StringUtils.hasText(persona.getAcercaDe())) {
            return new ResponseEntity("El contenido Acerca de es obligatorio.", HttpStatus.BAD_REQUEST);
        }
        if (!StringUtils.hasText(persona.getCelular())) {
            return new ResponseEntity("El celular es obligatorio.", HttpStatus.BAD_REQUEST);
        }
        if (!StringUtils.hasText(persona.getEmail())) {
            return new ResponseEntity("El Email es obligatorio.", HttpStatus.BAD_REQUEST);
        }

        personaService.crearPersona(persona);
        return new ResponseEntity("Persona creada", HttpStatus.CREATED);
    }

    @GetMapping("/get/persona")
    @ResponseBody
    public ResponseEntity<List<Persona>> verPersonas() {
        List<Persona> personas = personaService.verPersonas();
        return new ResponseEntity(personas, HttpStatus.OK);
    }

    @CrossOrigin(origins = "https://mi-portfolio-5b0c8.web.app", allowedHeaders = "*")
    @GetMapping("/get/persona/{id}")
    @ResponseBody
    public ResponseEntity<Persona> buscarPersona(@PathVariable Long id) {
        Persona persona = personaService.buscarPersona(id);
        if (persona == null) {
            return new ResponseEntity("la persona es inexistente", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(persona, HttpStatus.OK);
    }

    @CrossOrigin(origins = "https://mi-portfolio-5b0c8.web.app")
    @DeleteMapping("/delete/persona/{id}")
    public ResponseEntity borrarPersona(@PathVariable Long id) {
        personaService.borrarPersona(id);
        return new ResponseEntity("Persona borrada con exito", HttpStatus.OK);
    }

    @CrossOrigin(origins = "https://mi-portfolio-5b0c8.web.app", allowCredentials = "true")
    @PutMapping("/update/persona/{id}")
    public ResponseEntity<Persona> modificarPersona(@PathVariable Long id, @RequestBody Persona personaBody) {
        Persona persona = personaService.buscarPersona(id);
        if (persona != null) {
            if (personaBody.getNombre() != null)
                persona.setNombre(personaBody.getNombre());
            if (personaBody.getApellido() != null)
                persona.setApellido(personaBody.getApellido());
            if (personaBody.getImagenPerfil() != null)
                persona.setImagenPerfil(personaBody.getImagenPerfil());
            if (personaBody.getImagenHeader() != null)
                persona.setImagenHeader(personaBody.getImagenHeader());
            if (personaBody.getOcupacion() != null)
                persona.setOcupacion(personaBody.getOcupacion());
            if (personaBody.getCiudad() != null)
                persona.setCiudad(personaBody.getCiudad());
            if (personaBody.getPais() != null)
                persona.setPais(personaBody.getPais());
            if (personaBody.getAcercaDe() != null)
                persona.setAcercaDe(personaBody.getAcercaDe());
            if (personaBody.getCelular() != null)
                persona.setCelular(personaBody.getCelular());
            if (personaBody.getEmail() != null)
                persona.setEmail(personaBody.getEmail());
            personaService.crearPersona(persona);
            return new ResponseEntity(new Mensaje("La persona fue modificada con exito"), HttpStatus.OK);
        }
        return new ResponseEntity(new Mensaje("El id a modificar no existe"), HttpStatus.BAD_REQUEST);
    }
}
