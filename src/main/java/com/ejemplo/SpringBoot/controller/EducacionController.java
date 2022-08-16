
package com.ejemplo.SpringBoot.controller;

import com.ejemplo.SpringBoot.model.Educacion;
import com.ejemplo.SpringBoot.service.IEducacionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
        public void agregarEducacion(@RequestBody Educacion educacion){
        educacionService.crearEducacion(educacion);
        }

        @GetMapping("/get/educacion")
        @ResponseBody 
        public List<Educacion> verEducaciones(){
        return  educacionService.verEducaciones();
        }

        @GetMapping("/get/educacion/{id}")
        @ResponseBody 
        public Educacion buscarEducacion(@PathVariable Long id){
        return  educacionService.buscarEducacion(id);
        }

        @DeleteMapping ("/delete/educacion/{id}")
        public void borrarEducacion(@PathVariable Long id){
        educacionService.borrarEducacion(id);
        }

        @PutMapping ("/update/educacion/{id}")
        public void modificarEducacion(@PathVariable Long id, @RequestBody Educacion educacionBody){
        Educacion educacion = educacionService.buscarEducacion(id);
        if (educacion != null ) {
            if(educacionBody.getFotoUrl() != null)  educacion.setFotoUrl(educacionBody.getFotoUrl());
            if(educacionBody.getInstitucion()!= null)  educacion.setInstitucion(educacionBody.getInstitucion());
            if(educacionBody.getTitulo() != null)  educacion.setTitulo(educacionBody.getTitulo());
            if(educacionBody.getFechaInicio()!= null)  educacion.setFechaInicio(educacionBody.getFechaInicio());
            if(educacionBody.getFechaFin()!= null)  educacion.setFechaFin(educacionBody.getFechaFin());
            if(educacionBody.getLugar()!= null)  educacion.setLugar(educacionBody.getLugar());
            
           educacionService.crearEducacion(educacion);
        }
    }
    
}
