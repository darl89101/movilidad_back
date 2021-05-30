package com.sidenet.prueba.repositories;

import org.springframework.stereotype.Repository;

import com.sidenet.prueba.entities.Usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	 @Query("from Usuario where user_name = ?1")
	 Optional<Usuario> findByUser_name(String user_name);
}
