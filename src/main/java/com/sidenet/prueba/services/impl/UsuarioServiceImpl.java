package com.sidenet.prueba.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sidenet.prueba.entities.Usuario;
import com.sidenet.prueba.repositories.UsuarioRepository;
import com.sidenet.prueba.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Usuario obtenerPorId(int id) {
		return usuarioRepository.getOne(id);
	}

	@Override
	public List<Usuario> obtenerTodo() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario crear(Usuario usuario) throws Exception {

		Optional<Usuario> u = usuarioRepository.findByUser_name(usuario.getUser_name());
		
		if (!u.isPresent()) {
			throw new Exception("Ya existe un usuario con el mismo username");
		}
		
		return usuarioRepository.save(usuario);
	}
}
