package com.sidenet.prueba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sidenet.prueba.entities.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer> {

	// @Query("select c.id as idcliente, c.nombre as nombrecliente, c.fecha from Venta v inner join DetalleVenta dv on v.id = dv.idventa inner join Cliente c on v.idcliente = c.id inner join Producto p on dv.idproducto = p.id")
	@Query("from Venta")
	List<Venta> getAll();

}
