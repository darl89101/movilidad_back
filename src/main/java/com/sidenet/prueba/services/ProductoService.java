package com.sidenet.prueba.services;

import java.util.List;

import com.sidenet.prueba.entities.Producto;

public interface ProductoService {
	List<Producto> obtenerTodos();
	Producto crear(Producto producto) throws Exception;
	Producto actualizar(Integer id, Producto producto) throws Exception;
	void eliminar(Integer idProducto);
}
