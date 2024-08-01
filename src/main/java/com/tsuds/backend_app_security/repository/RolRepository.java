package com.tsuds.backend_app_security.repository;

import com.tsuds.backend_app_security.models.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {

    Rol findByRol(@Param("rol") String rol);
}
