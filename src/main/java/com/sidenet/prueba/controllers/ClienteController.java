package com.sidenet.prueba.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sidenet.prueba.entities.Cliente;
import com.sidenet.prueba.models.ClienteModel;
import com.sidenet.prueba.services.ClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@PostMapping
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<ClienteModel> guardar(@RequestBody ClienteModel model) throws Exception {

		Cliente c = new Cliente();
		c.setNombre(model.getNombre());
		c.setApellido(model.getApellido());
		c.setDni(model.getDni());
		c.setTelefono(model.getTelefono());
		c.setEmail(model.getEmail());
		
		c = clienteService.guardar(c);
		
		return new ResponseEntity<ClienteModel>(new ClienteModel(c.getId(), c.getNombre(), c.getApellido(), c.getDni(), c.getTelefono(), c.getEmail()), HttpStatus.OK);
	}
}
