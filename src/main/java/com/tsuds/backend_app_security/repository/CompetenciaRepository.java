package com.tsuds.backend_app_security.repository;

import com.tsuds.backend_app_security.models.Competencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetenciaRepository extends JpaRepository<Competencia, Integer> {

    Competencia findByNombre(@Param("nombre") String nombre);
}
