package com.sidenet.prueba.models;

import java.util.List;

public class VentaModel {
	private Integer idCliente;
	private List<DetalleVentaModel> detalleVenta;

	public VentaModel() {}
	
	public VentaModel(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public List<DetalleVentaModel> getDetalleVenta() {
		return detalleVenta;
	}

	public void setDetalleVenta(List<DetalleVentaModel> detalleVenta) {
		this.detalleVenta = detalleVenta;
	}

}
