package com.sidenet.prueba.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sidenet.prueba.entities.Usuario;
import com.sidenet.prueba.models.UsuarioModel;
import com.sidenet.prueba.services.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<List<UsuarioModel>> getAll() {
		List<Usuario> usuarios = usuarioService.obtenerTodo();

		List<UsuarioModel> users = new ArrayList<>();

		for (Usuario u : usuarios) {
			users.add(new UsuarioModel(u.getId(), u.getUsername(), u.getPassword(), u.getFullname()));
		}

		return new ResponseEntity<List<UsuarioModel>>(users, HttpStatus.OK);
	}

	@PostMapping
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<UsuarioModel> create(@RequestBody UsuarioModel model) throws Exception {

		Usuario u = new Usuario();
		u.setUsername(model.getUsername());
		u.setPassword(model.getPassword());
		u.setFullname(model.getFullName());

		u = usuarioService.crear(u);

		return new ResponseEntity<>(new UsuarioModel(u.getId(), u.getUsername(), u.getPassword(), u.getFullname()),
				HttpStatus.CREATED);
	}
}
