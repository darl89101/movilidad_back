package com.sidenet.prueba.services;

import java.util.List;

import com.sidenet.prueba.entities.Usuario;

public interface UsuarioService {
	Usuario obtenerPorId(int id);
	List<Usuario> obtenerTodo();
	Usuario crear(Usuario usuario) throws Exception;
}
