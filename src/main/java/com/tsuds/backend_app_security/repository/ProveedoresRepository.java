package com.tsuds.backend_app_security.repository;

import com.tsuds.backend_app_security.models.Proveedores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedoresRepository extends JpaRepository<Proveedores, Integer> {
}
