package com.sidenet.prueba.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sidenet.prueba.entities.Producto;
import com.sidenet.prueba.repositories.ProductoRepository;
import com.sidenet.prueba.services.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	public List<Producto> obtenerTodos() {
		return productoRepository.obtenerTodos();
	}

	@Override
	public Producto crear(Producto producto) throws Exception {
		Optional<Producto> o = productoRepository.consultarPorNombre(producto.getNombre());
		
		if (o.isPresent()) {
			throw new Exception("Ya existe un producto con nombre " + producto.getNombre());
		}
		
		return productoRepository.save(producto);
	}

	@Override
	public Producto actualizar(Integer id, Producto producto) throws Exception {
		Optional<Producto> o = productoRepository.findById(id);
		
		if (o.isPresent() && o.get().getId() != producto.getId()) {
			throw new Exception("Ya existe un producto con nombre " + producto.getNombre());
		}
		
		Producto pr = o.get();
		pr.setNombre(producto.getNombre());
		pr.setPrecio(producto.getPrecio());
		
		return productoRepository.save(pr);
	}

	@Override
	public void eliminar(Integer idProducto) {
		productoRepository.deleteById(idProducto);
	}

}
