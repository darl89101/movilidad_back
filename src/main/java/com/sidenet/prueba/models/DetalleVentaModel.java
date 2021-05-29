package com.sidenet.prueba.models;

public class DetalleVentaModel {
	private Integer idProducto;

	public DetalleVentaModel() {
	}

	public DetalleVentaModel(Integer idProducto) {
		super();
		this.idProducto = idProducto;
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

}
