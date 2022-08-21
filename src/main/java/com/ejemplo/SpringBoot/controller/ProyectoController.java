
package com.ejemplo.SpringBoot.controller;

import com.ejemplo.SpringBoot.model.Proyecto;
import com.ejemplo.SpringBoot.service.IProyectoService;
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
public class ProyectoController {
        
    @Autowired
    private IProyectoService proyectoService;
    
    @PostMapping("/new/proyecto")
        public ResponseEntity<?> agregarProyecto(@RequestBody Proyecto proyecto){
            if(!StringUtils.hasText(proyecto.getTitulo())) {
                return new ResponseEntity("El titulo es obligatoria.", HttpStatus.BAD_REQUEST);
            }
             if(!StringUtils.hasText(proyecto.getDescripcion())) {
                return new ResponseEntity("La descripcion es obligatoria.", HttpStatus.BAD_REQUEST);
            }
             if(!StringUtils.hasText(proyecto.getFechaRealizacion())) {
                return new ResponseEntity("La fecha de realizacion es obligatoria.", HttpStatus.BAD_REQUEST);
            }
              if(!StringUtils.hasText(proyecto.getProyectoUrl())) {
                return new ResponseEntity("La url es obligatoria.", HttpStatus.BAD_REQUEST);
            }
               if(proyecto.getIdPersona() == null){
                return new ResponseEntity("El idPersona es obligatorio.", HttpStatus.BAD_REQUEST);
            }
                      
            proyectoService.crearProyecto(proyecto);
            return new ResponseEntity("Educacion creada" ,HttpStatus.CREATED);
        }

        @GetMapping("/get/proyecto")
        @ResponseBody 
        public ResponseEntity<List<Proyecto>> verProyectos(){
            List<Proyecto> proyectos = proyectoService.verProyectos();
            return  new ResponseEntity(proyectos, HttpStatus.OK );
        }

        @GetMapping("/get/proyecto/{id}")
        @ResponseBody 
        public ResponseEntity<Proyecto> buscarProyecto(@PathVariable Long id){
            Proyecto proyecto = proyectoService.buscarProyecto(id);
            return new ResponseEntity(proyecto, HttpStatus.OK);
        }

        @DeleteMapping ("/delete/proyecto/{id}")
        public ResponseEntity borrarProyecto(@PathVariable Long id){
        proyectoService.borrarProyecto(id);
        return new ResponseEntity("Proyecto borrado con exito", HttpStatus.OK);
        }

        @PutMapping ("/update/proyecto/{id}")
        public ResponseEntity<Proyecto> modificarProyecto(@PathVariable Long id, @RequestBody Proyecto proyectoBody){
        Proyecto proyecto = proyectoService.buscarProyecto(id);
        if (proyecto != null ) {
            if(proyectoBody.getTitulo() != null)  proyecto.setTitulo(proyectoBody.getTitulo());
            if(proyectoBody.getDescripcion() != null)  proyecto.setDescripcion(proyectoBody.getDescripcion());
            if(proyectoBody.getFechaRealizacion() != null)  proyecto.setFechaRealizacion(proyectoBody.getFechaRealizacion());
            if(proyectoBody.getProyectoUrl() != null)  proyecto.setProyectoUrl(proyectoBody.getProyectoUrl());  
           proyectoService.crearProyecto(proyecto);
           return new ResponseEntity("El proyecto fue modificada con exito", HttpStatus.OK);
        }
        return new ResponseEntity("El id a modificar no existe", HttpStatus.BAD_REQUEST);
    }
    
}
