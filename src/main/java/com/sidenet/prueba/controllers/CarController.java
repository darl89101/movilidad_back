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

import com.sidenet.prueba.models.ApiResponse;
import com.sidenet.prueba.models.CarRequest;
import com.sidenet.prueba.models.CarResponse;
import com.sidenet.prueba.services.CarService;

@RestController
@RequestMapping("/api/cars")
public class CarController {
	
	@Autowired
	private CarService carService;
	
	@GetMapping
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<List<CarResponse>> getAll(@RequestParam String filter) throws Exception {
		return carService.findCars(filter);
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<CarResponse> getById(@PathVariable(name = "id") Integer id) throws Exception {		
		return carService.findById(id);
	}
	
	@PostMapping
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<CarResponse> create(@Valid @RequestBody CarRequest car) throws Exception {
		return carService.create(car);
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<CarResponse> update(@PathVariable(name = "id") Integer id, @Valid @RequestBody CarRequest car) throws Exception {
		return carService.update(car, id);
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<ApiResponse> delete(@PathVariable(name = "id") Integer id) throws Exception {
		return carService.delete(id);
	}
}