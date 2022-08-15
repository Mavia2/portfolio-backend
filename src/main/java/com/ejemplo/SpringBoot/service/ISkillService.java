
package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Skill;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface ISkillService  {
    public List<Skill> verSkills();
    
    public void crearSkill(Skill skill);
    
    public void borrarSkill(Long id);
    
    public Skill buscarSkill(Long id);
    
    
}
