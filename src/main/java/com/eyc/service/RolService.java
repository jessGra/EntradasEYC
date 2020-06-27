package com.eyc.service;

import com.eyc.enums.RolNombre;
import com.eyc.model.Rol;
import com.eyc.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RolService {

    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> obtenerPorRolNombre(RolNombre rolNombre){
        return rolRepository.findByRolNombre(rolNombre);
    }

    public boolean existePorRolNombre(RolNombre rolNombre){
        return rolRepository.existsByRolNombre(rolNombre);
    }

    public void guardar(Rol rol){
        rolRepository.save(rol);
    }
}
