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

import com.sidenet.prueba.entities.Cliente;
import com.sidenet.prueba.entities.DetalleVenta;
import com.sidenet.prueba.entities.Producto;
import com.sidenet.prueba.entities.Venta;
import com.sidenet.prueba.models.DetalleVenta2Model;
import com.sidenet.prueba.models.VentaDetalladaModel;
import com.sidenet.prueba.models.VentaModel;
import com.sidenet.prueba.repositories.ClienteRepository;
import com.sidenet.prueba.repositories.DetalleVentaRepository;
import com.sidenet.prueba.repositories.ProductoRepository;
import com.sidenet.prueba.services.VentaService;

@RestController
@RequestMapping("/api/venta")
public class VentaController {

	@Autowired
	private VentaService ventaService;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private DetalleVentaRepository detalleVentaRepository;

	@Autowired
	private ProductoRepository productoRepository;
	
	@PostMapping
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<Void> generar(@RequestBody VentaModel model) {

		ventaService.generarVenta(model);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@GetMapping
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<List<VentaDetalladaModel>> getAll() {

		List<Venta> ventas = ventaService.getAll();
		List<VentaDetalladaModel> res = new ArrayList<VentaDetalladaModel>();
		
		for (Venta v : ventas) {
			Cliente c = clienteRepository.findById(v.getIdcliente()).get();
			List<DetalleVenta> dtalle =  detalleVentaRepository.findByIdVenta(v.getId());
			List<DetalleVenta2Model> detalled = new ArrayList<DetalleVenta2Model>(); 
			
			for (DetalleVenta dv : dtalle) {
				Producto p = productoRepository.findById(dv.getIdproducto()).get();
				
				detalled.add(new DetalleVenta2Model(dv.getIdproducto(), p.getNombre()));
			}
			
			res.add(new VentaDetalladaModel(v.getIdcliente(), c.getNombre(), v.getFecha(), detalled));	
		}
		
		return new ResponseEntity<List<VentaDetalladaModel>>(res, HttpStatus.OK);
	}
}
