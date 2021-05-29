package com.sidenet.prueba.models;

public class DetalleVenta2Model {
	private Integer idProducto;
	private String nombreProducto;

	public DetalleVenta2Model() {
	}

	public DetalleVenta2Model(Integer idProducto, String nombreProducto) {
		super();
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

}
