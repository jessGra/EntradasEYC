package com.eyc.service;

import com.eyc.model.Usuario;
import com.eyc.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> obtenerLista(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> obtenerPorId(long id){
        return usuarioRepository.findById(id);
    }

    public Optional<Usuario> obtenerPorNombre(String nombre){
        return usuarioRepository.findByNombre(nombre);
    }

    public void guardar(Usuario usuario){
        usuarioRepository.save(usuario);
    }

    public boolean existeUsuarioId(long id){
        return usuarioRepository.existsById(id);
    }

    public boolean existeUsuarioNombre(String nombre){
        return usuarioRepository.existsByNombre(nombre);
    }
}
