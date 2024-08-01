package com.tsuds.backend_app_security.repository;

import com.tsuds.backend_app_security.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario findByUsername(@Param("username") String username);
}
