package com.sidenet.prueba.repositories;

import org.springframework.stereotype.Repository;

import com.sidenet.prueba.entities.Usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	Optional<Usuario> findByUsername(String username);
}
