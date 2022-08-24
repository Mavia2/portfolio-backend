
package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Experiencia;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IExperienciaService {
    
    public List<Experiencia> verExperiencias();
    
    public Experiencia crearExperiencia(Experiencia experiencia);
    
    public void borrarExperiencia(Long id);
    
    public Experiencia buscarExperiencia(Long id);

}
