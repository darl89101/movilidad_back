package com.sidenet.prueba.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sidenet.prueba.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	Cliente findByNombre(String nombre);
	Optional<Cliente> findByEmail(String email);
}
