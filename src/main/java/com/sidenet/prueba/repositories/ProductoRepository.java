package com.sidenet.prueba.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sidenet.prueba.entities.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
	@Query("from Producto")
	List<Producto> obtenerTodos();
	
	@Query("from Producto where nombre = ?1")
	Optional<Producto> consultarPorNombre(String nombre);
}
