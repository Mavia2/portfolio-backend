package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Usuario;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IUsuarioService {
    public List<Usuario> verUsuarios();
    
    public void crearUsuario(Usuario usuario);
    
    public void borrarUsuario(Long id);
    
    public Usuario buscarUsuario(Long id);
    
}
