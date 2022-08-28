
package com.ejemplo.SpringBoot.controller;

import com.ejemplo.SpringBoot.model.Skill;
import com.ejemplo.SpringBoot.security.controller.Mensaje;
import com.ejemplo.SpringBoot.service.ISkillService;
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

@CrossOrigin(origins = "https://mi-portfolio-5b0c8.web.app", allowCredentials = "true")
@RestController
public class SkillControler {

    @Autowired
    private ISkillService skillService;

    @PostMapping("/new/skill")
    public ResponseEntity<?> agregarSkill(@RequestBody Skill skill) {
        if (!StringUtils.hasText(skill.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre de la skill es obligatorio."), HttpStatus.BAD_REQUEST);
        }
        if (skill.getPorcentaje() == null) {
            return new ResponseEntity(new Mensaje("El porcentaje de la skill es obligatorio."), HttpStatus.BAD_REQUEST);
        }
        if (skill.getIdPersona() == null) {
            return new ResponseEntity(new Mensaje("El idPersona es obligatorio."), HttpStatus.BAD_REQUEST);
        }
        skillService.crearSkill(skill);
        return new ResponseEntity(new Mensaje("Skill creada con éxito."), HttpStatus.CREATED);
    }

    @GetMapping("/get/skill")
    @ResponseBody
    public ResponseEntity<List<Skill>> verSkills() {
        List<Skill> skills = skillService.verSkills();
        return new ResponseEntity(skills, HttpStatus.OK);
    }

    @GetMapping("/get/skill/{id}")
    @ResponseBody
    public ResponseEntity<Skill> buscarSkill(@PathVariable Long id) {
        Skill skill = skillService.buscarSkill(id);
        if (skill == null) {
            return new ResponseEntity(new Mensaje("La Skill es inexistente."), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(skill, HttpStatus.OK);
    }

    @DeleteMapping("/delete/skill/{id}")
    public ResponseEntity borrarSkill(@PathVariable Long id) {
        skillService.borrarSkill(id);
        return new ResponseEntity(new Mensaje("Skill borrada con éxito."), HttpStatus.OK);
    }

    @PutMapping("/update/skill/{id}")
    public ResponseEntity<Skill> modificarSkill(@PathVariable Long id, @RequestBody Skill skillBody) {
        Skill skill = skillService.buscarSkill(id);
        if (skill != null) {
            if (skillBody.getNombre() != null)
                skill.setNombre(skillBody.getNombre());
            if (skillBody.getPorcentaje() != null)
                skill.setPorcentaje(skillBody.getPorcentaje());

            skillService.crearSkill(skill);
            return new ResponseEntity(new Mensaje("La skill fue modificada con éxito."), HttpStatus.OK);
        }
        return new ResponseEntity(new Mensaje("El id a modificar no existe."), HttpStatus.BAD_REQUEST);
    }
}
