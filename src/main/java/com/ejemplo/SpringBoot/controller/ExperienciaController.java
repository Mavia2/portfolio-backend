
package com.ejemplo.SpringBoot.controller;

import com.ejemplo.SpringBoot.model.Experiencia;
import com.ejemplo.SpringBoot.service.IExperienciaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExperienciaController {
    @Autowired
    private IExperienciaService experienciaService;
    
    @PostMapping("/new/experiencia")
        public ResponseEntity<?> agregarExperiencia(@RequestBody Experiencia experiencia){
            if(!StringUtils.hasText(experiencia.getFotoUrl())) {
                return new ResponseEntity("La URL de la foto es obligatoria.", HttpStatus.BAD_REQUEST);
                }
            if(!StringUtils.hasText(experiencia.getInstitucion())) {
                return new ResponseEntity("La institución es obligatoria.", HttpStatus.BAD_REQUEST);
            }
            if(!StringUtils.hasText(experiencia.getCargo())) {
                return new ResponseEntity("El cargo desarrollado es obligatorio.", HttpStatus.BAD_REQUEST);
            }
            if(!StringUtils.hasText(experiencia.getDescripcion())) {
                return new ResponseEntity("La descripción es obligatoria.", HttpStatus.BAD_REQUEST);
            }
            if(!StringUtils.hasText(experiencia.getFechaInicio())) {
                return new ResponseEntity("La fecha de Inicio es obligatoria.", HttpStatus.BAD_REQUEST);
            }
            if(!StringUtils.hasText(experiencia.getFechaFin())) {
                return new ResponseEntity("La fecha de finalización es obligatoria.", HttpStatus.BAD_REQUEST);
            }
            if(!StringUtils.hasText(experiencia.getCargo())) {
                return new ResponseEntity("El cargo desarrollado es obligatorio.", HttpStatus.BAD_REQUEST);
            }
            if(!StringUtils.hasText(experiencia.getLugar())) {
                return new ResponseEntity("El lugar es obligatorio.", HttpStatus.BAD_REQUEST); 
            }
            if(experiencia.getIdPersona() == null){
                return new ResponseEntity("El idPersona es obligatorio.", HttpStatus.BAD_REQUEST);
            }
            experienciaService.crearExperiencia(experiencia);
            return new ResponseEntity("Experiencia creada" ,HttpStatus.CREATED);
        }    

        @GetMapping("/get/experiencia")
        @ResponseBody 
        public ResponseEntity<List<Experiencia>> verExperiencias(){
            List<Experiencia> experiencias = experienciaService.verExperiencias();
            return  new ResponseEntity(experiencias, HttpStatus.OK );
        }
        

        @GetMapping("/get/experiencia/{id}")
        @ResponseBody 
        public ResponseEntity<Experiencia> buscarExperiencia(@PathVariable Long id){
            Experiencia experiencia = experienciaService.buscarExperiencia(id);
             if(experiencia == null) {
                 return new ResponseEntity("la experiencia es inexistente", HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity(experiencia, HttpStatus.OK);
        }
        

        @DeleteMapping ("/delete/experiencia/{id}")
        public ResponseEntity borrarExperiencia(@PathVariable Long id){
        experienciaService.borrarExperiencia(id);
        return new ResponseEntity("Experiencia borrada con exito", HttpStatus.OK);
        }
        

        @PutMapping ("/update/experiencia/{id}")
        public ResponseEntity<Experiencia> modificarExperiencia(@PathVariable Long id, @RequestBody Experiencia experienciaBody){
        Experiencia experiencia = experienciaService.buscarExperiencia(id);
        
        if (experiencia != null ) {
            if(experienciaBody.getFotoUrl() != null)  experiencia.setFotoUrl(experienciaBody.getFotoUrl());
            if(experienciaBody.getInstitucion()!= null)  experiencia.setInstitucion(experienciaBody.getInstitucion());
            if(experienciaBody.getCargo() != null)  experiencia.setCargo(experienciaBody.getCargo());
            if(experienciaBody.getDescripcion()!= null)  experiencia.setDescripcion(experienciaBody.getDescripcion());
            if(experienciaBody.getFechaInicio()!= null)  experiencia.setFechaInicio(experienciaBody.getFechaInicio());
            if(experienciaBody.getFechaFin()!= null)  experiencia.setFechaFin(experienciaBody.getFechaFin());
            if(experienciaBody.getLugar()!= null)  experiencia.setLugar(experienciaBody.getLugar());
            
           experienciaService.crearExperiencia(experiencia);
            return new ResponseEntity("La experiencia fue modificada con exito", HttpStatus.OK);
        }
         return new ResponseEntity("El id a modificar no existe", HttpStatus.BAD_REQUEST);
    }
}
