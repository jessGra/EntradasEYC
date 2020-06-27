package com.eyc.security.service;

import com.eyc.model.Usuario;
import com.eyc.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.obtenerPorNombre(nombre).orElseThrow(() -> new UsernameNotFoundException(nombre));
        return UsuarioPrincipal.build(usuario);
    }
}
