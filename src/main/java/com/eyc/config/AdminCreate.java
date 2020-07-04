package com.eyc.config;

import com.eyc.enums.RolNombre;
import com.eyc.model.Rol;
import com.eyc.model.Usuario;
import com.eyc.service.RolService;
import com.eyc.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unused")
@Service
public class AdminCreate implements CommandLineRunner {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    RolService rolService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
    	
		/**
		 Rol rolAdmin = new Rol(); 
		 rolAdmin.setRolNombre(RolNombre.ROLE_ADMIN); 
		 Rol rolUser = new Rol(); 
		 rolUser.setRolNombre(RolNombre.ROLE_USER); 
		 
		 Usuario adminUser = new Usuario("EYC administrador", passwordEncoder.encode("159administrador951"));
		 
		 Set<Rol> roles = new HashSet<>(); 
		 roles.add(rolAdmin); 
		 roles.add(rolUser);
		 adminUser.setRoles(roles);
		//insert admin
		 rolService.guardar(rolAdmin);
		 rolService.guardar(rolUser);
		 usuarioService.guardar(adminUser);
		  
		 Usuario normalUser = new Usuario("EYC limitado", passwordEncoder.encode("limitado159")); 
		 Set<Rol> normalUserroles = new HashSet<>(); 
		 normalUserroles.add(rolUser);
		 normalUser.setRoles(normalUserroles); 
		 
		 //insert normal user
		 usuarioService.guardar(normalUser);
		 **/
    }
}
