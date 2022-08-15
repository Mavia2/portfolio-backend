package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Usuario;
import com.ejemplo.SpringBoot.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService{
    @Autowired
    public UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> verUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public void crearUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void borrarUsuario(Long id) {
       usuarioRepository.deleteById(id);
    }

    @Override
    public Usuario buscarUsuario(Long id) {
       return usuarioRepository.findById(id).orElse(null);
    }
    
    
    
}
