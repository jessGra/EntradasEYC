package com.eyc.repository;

        import com.eyc.enums.RolNombre;
        import com.eyc.model.Rol;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

        import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
    boolean existsByRolNombre(RolNombre rolNombre);
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
