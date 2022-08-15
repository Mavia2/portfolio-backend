
package com.ejemplo.SpringBoot.controller;

import com.ejemplo.SpringBoot.model.Educacion;
import com.ejemplo.SpringBoot.model.Experiencia;
import com.ejemplo.SpringBoot.model.Persona;
import com.ejemplo.SpringBoot.model.Proyecto;
import com.ejemplo.SpringBoot.model.Skill;
import com.ejemplo.SpringBoot.model.Usuario;
import com.ejemplo.SpringBoot.service.IEducacionService;
import com.ejemplo.SpringBoot.service.IExperienciaService;
import com.ejemplo.SpringBoot.service.IPersonaService;
import com.ejemplo.SpringBoot.service.IProyectoService;
import com.ejemplo.SpringBoot.service.ISkillService;
import com.ejemplo.SpringBoot.service.IUsuarioService;
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
public class Controller {
    // Persona
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
        public Persona buscarPersona(@PathVariable Long id){
        return  persoServ.buscarPersona(id);
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
    
    //Experiencia
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
    
   //Educacion
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
    
         //Skill
    @Autowired
    private ISkillService skillService;
    
    @PostMapping("/new/skill")
        public void agregarSkill(@RequestBody Skill skill){
        skillService.crearSkill(skill);
        }

        @GetMapping("/get/skill")
        @ResponseBody 
        public List<Skill> verSkills(){
        return  skillService.verSkills();
        }

        @GetMapping("/get/skill/{id}")
        @ResponseBody 
        public Skill buscarSkill(@PathVariable Long id){
        return  skillService.buscarSkill(id);
        }

        @DeleteMapping ("/delete/skill/{id}")
        public void borrarSkill(@PathVariable Long id){
        skillService.borrarSkill(id);
        }

        @PutMapping ("/update/skill/{id}")
        public void modificarSkill(@PathVariable Long id, @RequestBody Skill skillBody){
        Skill skill = skillService.buscarSkill(id);
        if (skill != null ) {
            if(skillBody.getNombre() != null)  skill.setNombre(skillBody.getNombre());
            if(skillBody.getPorcentaje()!= null)  skill.setPorcentaje(skillBody.getPorcentaje());
            
            
           skillService.crearSkill(skill);
        }
    }
  //Proyecto
    @Autowired
    private IProyectoService proyectoService;
    
    @PostMapping("/new/proyecto")
        public void agregarProyecto(@RequestBody Proyecto proyecto){
        proyectoService.crearProyecto(proyecto);
        }

        @GetMapping("/get/proyecto")
        @ResponseBody 
        public List<Proyecto> verProyectos(){
        return  proyectoService.verProyectos();
        }

        @GetMapping("/get/proyecto/{id}")
        @ResponseBody 
        public Proyecto buscarProyecto(@PathVariable Long id){
        return  proyectoService.buscarProyecto(id);
        }

        @DeleteMapping ("/delete/proyecto/{id}")
        public void borrarProyecto(@PathVariable Long id){
        proyectoService.borrarProyecto(id);
        }

        @PutMapping ("/update/proyecto/{id}")
        public void modificarProyecto(@PathVariable Long id, @RequestBody Proyecto proyectoBody){
        Proyecto proyecto = proyectoService.buscarProyecto(id);
        if (proyecto != null ) {
            if(proyectoBody.getTitulo() != null)  proyecto.setTitulo(proyectoBody.getTitulo());
            if(proyectoBody.getDescripcion()!= null)  proyecto.setDescripcion(proyectoBody.getDescripcion());
            if(proyectoBody.getFechaRealizacion()!= null)  proyecto.setFechaRealizacion(proyectoBody.getFechaRealizacion());
            if(proyectoBody.getProyectoUrl() != null)  proyecto.setProyectoUrl(proyectoBody.getProyectoUrl());
            
           proyectoService.crearProyecto(proyecto);
        }
    }   
        
        //Usuario
    @Autowired
    private IUsuarioService usuarioService;
    
    @PostMapping("/new/usuario")
        public void agregarUsuario(@RequestBody Usuario usuario){
        usuarioService.crearUsuario(usuario);
        }

        @GetMapping("/get/usuario")
        @ResponseBody 
        public List<Usuario> verUsuarios(){
        return  usuarioService.verUsuarios();
        }

        @GetMapping("/get/usuario/{id}")
        @ResponseBody 
        public Usuario buscarUsuario(@PathVariable Long id){
        return  usuarioService.buscarUsuario(id);
        }

        @DeleteMapping ("/delete/usuario/{id}")
        public void borrarUsuario(@PathVariable Long id){
        usuarioService.borrarUsuario(id);
        }

        @PutMapping ("/update/usuario/{id}")
        public void modificarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioBody){
        Usuario usuario = usuarioService.buscarUsuario(id);
        if (usuario != null ) {
            if(usuarioBody.getEmail() != null)  usuario.setEmail(usuarioBody.getEmail());
            if(usuarioBody.getPassword()!= null)  usuario.setPassword(usuarioBody.getPassword());
            
            
           usuarioService.crearUsuario(usuario);
        }
    }    
}
