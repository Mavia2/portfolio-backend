package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Educacion;
import com.ejemplo.SpringBoot.repository.EducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EducacionService implements IEducacionService{
    @Autowired
    public EducacionRepository educacionRepository;

    @Override
    public List<Educacion> verEducaciones() {
        return educacionRepository.findAll();
    }

    @Override
    public void crearEducacion(Educacion educacion) {
        educacionRepository.save(educacion);
    }

    @Override
    public void borrarEducacion(Long id) {
       educacionRepository.deleteById(id);
    }

    @Override
    public Educacion buscarEducacion(Long id) {
       return educacionRepository.findById(id).orElse(null);
    }
    
}

    
    

