package com.sidenet.prueba.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sidenet.prueba.entities.Displacement;
import com.sidenet.prueba.models.ApiResponse;
import com.sidenet.prueba.services.DisplacementService;

@RestController
@RequestMapping("/api/displacements")
public class DisplacementController {
	
	@Autowired
	private DisplacementService displacementService;
	
	@GetMapping
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<List<Displacement>> getAll(@RequestParam String filter) throws Exception {
		return displacementService.findAll(filter);
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<Displacement> getById(@PathVariable(name = "id") Integer id) throws Exception {		
		return displacementService.findById(id);
	}
	
	@PostMapping
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<Displacement> create(@Valid @RequestBody Displacement displacement) throws Exception {
		return displacementService.create(displacement);
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<Displacement> update(@PathVariable(name = "id") Integer id, @Valid @RequestBody Displacement displacement) throws Exception {
		return displacementService.update(displacement, id);
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<ApiResponse> delete(@PathVariable(name = "id") Integer id) throws Exception {
		return displacementService.delete(id);
	}
}