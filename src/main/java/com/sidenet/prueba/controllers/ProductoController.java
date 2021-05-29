package com.sidenet.prueba.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sidenet.prueba.entities.Producto;
import com.sidenet.prueba.models.ProductoModel;
import com.sidenet.prueba.services.ProductoService;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
	@GetMapping
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<List<ProductoModel>> getAll() {
		
		List<Producto> productos = productoService.obtenerTodos();
		List<ProductoModel> pModel = new ArrayList<ProductoModel>();
		
		for (Producto p : productos) {
			pModel.add(new ProductoModel(p.getId(), p.getNombre(), p.getPrecio()));
		}
		
		return new ResponseEntity<List<ProductoModel>>(pModel, HttpStatus.OK);
	}
	
	@PostMapping
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<ProductoModel> crear(@RequestBody ProductoModel model) throws Exception {
		Producto entity = new Producto();
		entity.setNombre(model.getNombre());
		entity.setPrecio(model.getPrecio());
		
		entity = productoService.crear(entity);
		
		return new ResponseEntity<ProductoModel>(new ProductoModel(entity.getId(), entity.getNombre(), entity.getPrecio()), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<ProductoModel> actualizar(@PathVariable(name = "id") Integer id, @RequestBody ProductoModel model) throws Exception {
		Producto entity = new Producto();
		entity.setId(id);
		entity.setNombre(model.getNombre());
		entity.setPrecio(model.getPrecio());
		
		entity = productoService.actualizar(id, entity);
		
		return new ResponseEntity<ProductoModel>(new ProductoModel(entity.getId(), entity.getNombre(), entity.getPrecio()), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<Void> eliminar(@PathVariable(name = "id") Integer id) throws Exception {
		productoService.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
