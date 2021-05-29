package com.sidenet.prueba.services;

import java.util.List;

import com.sidenet.prueba.entities.Venta;
import com.sidenet.prueba.models.VentaModel;

public interface VentaService {
	void generarVenta(VentaModel model);
	List<Venta> getAll();
}
