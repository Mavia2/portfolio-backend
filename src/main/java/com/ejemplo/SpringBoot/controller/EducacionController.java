
package com.ejemplo.SpringBoot.controller;


import com.ejemplo.SpringBoot.model.Educacion;
import com.ejemplo.SpringBoot.service.IEducacionService;
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
public class EducacionController {
    
    @Autowired
    private IEducacionService educacionService;
    
    @PostMapping("/new/educacion")
        public ResponseEntity<?> agregarEducacion(@RequestBody Educacion educacion){
            if(!StringUtils.hasText(educacion.getFotoUrl())) {
                return new ResponseEntity("La URL de la foto es obligatoria.", HttpStatus.BAD_REQUEST);
            }
             if(!StringUtils.hasText(educacion.getInstitucion())) {
                return new ResponseEntity("La institución es obligatoria.", HttpStatus.BAD_REQUEST);
            }
             if(!StringUtils.hasText(educacion.getTitulo())) {
                return new ResponseEntity("El título es obligatorio.", HttpStatus.BAD_REQUEST);
            }
              if(!StringUtils.hasText(educacion.getFechaInicio())) {
                return new ResponseEntity("La fecha de inicio obligatoria.", HttpStatus.BAD_REQUEST);
            }
               if(!StringUtils.hasText(educacion.getFechaFin())) {
                return new ResponseEntity("La fecha de finalización es obligatoria.", HttpStatus.BAD_REQUEST);
            }
                if(!StringUtils.hasText(educacion.getLugar())) {
                return new ResponseEntity("El lugar es obligatorio.", HttpStatus.BAD_REQUEST);
            }
                if(educacion.getIdPersona() == null){
                return new ResponseEntity("El idPersona es obligatorio.", HttpStatus.BAD_REQUEST);
            }
            
            educacionService.crearEducacion(educacion);
            return new ResponseEntity("Educacion creada" ,HttpStatus.CREATED);
        }

        @GetMapping("/get/educacion")
        @ResponseBody 
        public ResponseEntity<List<Educacion>> verEducaciones(){
            List<Educacion> educaciones = educacionService.verEducaciones();
            return  new ResponseEntity(educaciones, HttpStatus.OK );
        }

        @GetMapping("/get/educacion/{id}")
        @ResponseBody 
        public ResponseEntity<Educacion> buscarEducacion(@PathVariable Long id){
            Educacion educacion = educacionService.buscarEducacion(id);
            return new ResponseEntity(educacion, HttpStatus.OK);
        }

        @DeleteMapping ("/delete/educacion/{id}")
        public ResponseEntity borrarEducacion(@PathVariable Long id){
        educacionService.borrarEducacion(id);
        return new ResponseEntity("Educacion borrada con exito", HttpStatus.OK);
        }

        @PutMapping ("/update/educacion/{id}")
        public ResponseEntity<Educacion> modificarEducacion(@PathVariable Long id, @RequestBody Educacion educacionBody){
        Educacion educacion = educacionService.buscarEducacion(id);
        if (educacion != null ) {
            if(educacionBody.getFotoUrl() != null)  educacion.setFotoUrl(educacionBody.getFotoUrl());
            if(educacionBody.getInstitucion()!= null)  educacion.setInstitucion(educacionBody.getInstitucion());
            if(educacionBody.getTitulo() != null)  educacion.setTitulo(educacionBody.getTitulo());
            if(educacionBody.getFechaInicio()!= null)  educacion.setFechaInicio(educacionBody.getFechaInicio());
            if(educacionBody.getFechaFin()!= null)  educacion.setFechaFin(educacionBody.getFechaFin());
            if(educacionBody.getLugar()!= null)  educacion.setLugar(educacionBody.getLugar());
            
           educacionService.crearEducacion(educacion);
           return new ResponseEntity("La educacion fue modificada con exito", HttpStatus.OK);
        }
        return new ResponseEntity("El id a modificar no existe", HttpStatus.BAD_REQUEST);
    }
    
}
