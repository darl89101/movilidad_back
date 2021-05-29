package com.sidenet.prueba.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sidenet.prueba.entities.DetalleVenta;
import com.sidenet.prueba.entities.Venta;
import com.sidenet.prueba.models.DetalleVentaModel;
import com.sidenet.prueba.models.VentaModel;
import com.sidenet.prueba.repositories.DetalleVentaRepository;
import com.sidenet.prueba.repositories.VentaRepository;
import com.sidenet.prueba.services.VentaService;

@Service
public class VentaServiceImpl implements VentaService {

	@Autowired
	private VentaRepository ventaRepository;

	@Autowired
	private DetalleVentaRepository detalleVentaRepository;

	@Override
	public void generarVenta(VentaModel model) {
		Venta venta = new Venta();
		venta.setIdcliente(model.getIdCliente());
		venta.setFecha(new Date());

		venta = ventaRepository.save(venta);

		if (model.getDetalleVenta() != null) {
			for (DetalleVentaModel detalle : model.getDetalleVenta()) {
				DetalleVenta detalleV = new DetalleVenta();
				detalleV.setIdventa(venta.getId());
				detalleV.setIdproducto(detalle.getIdProducto());

				detalleVentaRepository.save(detalleV);
			}
		}
	}

	@Override
	public List<Venta> getAll() {
		// TODO Auto-generated method stub
		return ventaRepository.getAll();
	}

}
