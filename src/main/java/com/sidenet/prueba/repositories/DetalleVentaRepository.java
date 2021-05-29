package com.sidenet.prueba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sidenet.prueba.entities.DetalleVenta;

@Repository
public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Integer> {
	@Query("from DetalleVenta where idventa = ?1")
	List<DetalleVenta> findByIdVenta(Integer idventa);
}
