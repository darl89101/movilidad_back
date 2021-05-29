package com.sidenet.prueba.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sidenet.prueba.entities.Cliente;
import com.sidenet.prueba.repositories.ClienteRepository;
import com.sidenet.prueba.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public Cliente guardar(Cliente cliente) throws Exception {
		
		Optional<Cliente> c = clienteRepository.findByEmail(cliente.getEmail());
		
		if (c.isPresent()) {
			throw new Exception("Ya existe un cliente con correo " + cliente.getEmail());
		}
		
		return clienteRepository.save(cliente);
	}

}
