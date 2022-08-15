package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Skill;
import com.ejemplo.SpringBoot.repository.SkillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService implements ISkillService {
    @Autowired
    public SkillRepository skillRepository;

    @Override
    public List<Skill> verSkills() {
        return skillRepository.findAll();
    }

    @Override
    public void crearSkill(Skill skill) {
        skillRepository.save(skill);
    }

    @Override
    public void borrarSkill(Long id) {
       skillRepository.deleteById(id);
    }

    @Override
    public Skill buscarSkill(Long id) {
       return skillRepository.findById(id).orElse(null);
    }
    
}
