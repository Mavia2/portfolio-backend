package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Proyecto;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IProyectoService {
    public List<Proyecto> verProyectos();
    
    public void crearProyecto(Proyecto proyecto);
    
    public void borrarProyecto(Long id);
    
    public Proyecto buscarProyecto(Long id);
    
}
