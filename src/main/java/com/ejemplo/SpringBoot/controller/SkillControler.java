
package com.ejemplo.SpringBoot.controller;

import com.ejemplo.SpringBoot.model.Proyecto;
import com.ejemplo.SpringBoot.model.Skill;
import com.ejemplo.SpringBoot.service.IProyectoService;
import com.ejemplo.SpringBoot.service.ISkillService;
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
public class SkillControler {
    
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
}
