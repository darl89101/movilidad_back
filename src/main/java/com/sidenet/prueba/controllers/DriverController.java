package com.sidenet.prueba.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sidenet.prueba.entities.Driver;
import com.sidenet.prueba.services.DriverService;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {
	
	@Autowired
	private DriverService driverService;
	
	@GetMapping
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<List<Driver>> getAll(@RequestParam String filter) throws Exception {
		List<Driver> drivers = driverService.findDrivers(filter);
		
		return ResponseEntity.ok(drivers);
	}
	
	@PostMapping
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<Driver> create(@RequestBody Driver driver) throws Exception {		
		Driver created = driverService.create(driver);		
		return ResponseEntity.ok(created);
	}
}
