package com.tsuds.backend_app_security.repository;

import com.tsuds.backend_app_security.models.ItemFactura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemFacturaRepository extends JpaRepository<ItemFactura, Integer> {
}
