package com.tsuds.backend_app_security.repository;

import com.tsuds.backend_app_security.models.TipoPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPagoRepository extends JpaRepository<TipoPago, Integer> {
}
