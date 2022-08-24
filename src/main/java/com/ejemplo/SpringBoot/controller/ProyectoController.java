
package com.ejemplo.SpringBoot.controller;

import com.ejemplo.SpringBoot.model.Proyecto;
import com.ejemplo.SpringBoot.security.controller.Mensaje;
import com.ejemplo.SpringBoot.service.IProyectoService;
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

@CrossOrigin(origins="http://localhost:4200", allowCredentials = "true" )
@RestController
public class ProyectoController {
        
    @Autowired
    private IProyectoService proyectoService;
    
    @PostMapping("/new/proyecto")
        public ResponseEntity<?> agregarProyecto(@RequestBody Proyecto proyecto){
            if(!StringUtils.hasText(proyecto.getTitulo())) {
                return new ResponseEntity(new Mensaje("El título es obligatorio."), HttpStatus.BAD_REQUEST);
            }
             if(!StringUtils.hasText(proyecto.getDescripcion())) {
                return new ResponseEntity(new Mensaje("La descripción es obligatoria."), HttpStatus.BAD_REQUEST);
            }
             if(!StringUtils.hasText(proyecto.getFechaRealizacion())) {
                return new ResponseEntity(new Mensaje("La fecha de realización es obligatoria."), HttpStatus.BAD_REQUEST);
            }
              if(!StringUtils.hasText(proyecto.getProyectoUrl())) {
                return new ResponseEntity(new Mensaje("La url es obligatoria."), HttpStatus.BAD_REQUEST);
            }
               if(proyecto.getIdPersona() == null){
                return new ResponseEntity(new Mensaje("El idPersona es obligatorio."), HttpStatus.BAD_REQUEST);
            }
                      
            proyectoService.crearProyecto(proyecto);
            return new ResponseEntity(new Mensaje("Proyecto creado con éxito.") ,HttpStatus.CREATED);
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
            if(proyecto == null) {
                 return new ResponseEntity(new Mensaje("El proyecto es inexistente."), HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity(proyecto, HttpStatus.OK);
        }

        @DeleteMapping ("/delete/proyecto/{id}")
        public ResponseEntity borrarProyecto(@PathVariable Long id){
        proyectoService.borrarProyecto(id);
        return new ResponseEntity(new Mensaje("Proyecto borrado con éxito."), HttpStatus.OK);
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
           return new ResponseEntity(new Mensaje("El proyecto fue modificado con éxito."), HttpStatus.OK);
        }
        return new ResponseEntity(new Mensaje("El id a modificar no existe,"), HttpStatus.BAD_REQUEST);
    }
    
}
