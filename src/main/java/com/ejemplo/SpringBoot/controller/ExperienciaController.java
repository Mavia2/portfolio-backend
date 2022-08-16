
package com.ejemplo.SpringBoot.controller;

import com.ejemplo.SpringBoot.model.Experiencia;
import com.ejemplo.SpringBoot.service.IExperienciaService;
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
public class ExperienciaController {
     @Autowired
    private IExperienciaService experienciaService;
    
    @PostMapping("/new/experiencia")
        public void agregarExperiencia(@RequestBody Experiencia experiencia){
        experienciaService.crearExperiencia(experiencia);
        }

        @GetMapping("/get/experiencia")
        @ResponseBody 
        public List<Experiencia> verExperiencias(){
        return  experienciaService.verExperiencias();
        }

        @GetMapping("/get/experiencia/{id}")
        @ResponseBody 
        public Experiencia buscarExperiencia(@PathVariable Long id){
        return  experienciaService.buscarExperiencia(id);
        }

        @DeleteMapping ("/delete/experiencia/{id}")
        public void borrarExperiencia(@PathVariable Long id){
        experienciaService.borrarExperiencia(id);
        }

        @PutMapping ("/update/experiencia/{id}")
        public void modificarExperiencia(@PathVariable Long id, @RequestBody Experiencia experienciaBody){
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
        }
    }
}
