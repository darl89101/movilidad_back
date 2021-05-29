package com.sidenet.prueba.models;

import java.util.Date;
import java.util.List;

public class VentaDetalladaModel {
	private Integer idCliente;
	private String nombreCliente;
	private Date fecha;
	private List<DetalleVenta2Model> detalle;

	public VentaDetalladaModel() {
	}

	public VentaDetalladaModel(Integer idCliente, String nombreCliente, Date fecha, List<DetalleVenta2Model> detalle) {
		super();
		this.idCliente = idCliente;
		this.nombreCliente = nombreCliente;
		this.fecha = fecha;
		this.detalle = detalle;
	}

	

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<DetalleVenta2Model> getDetalle() {
		return detalle;
	}

	public void setDetalle(List<DetalleVenta2Model> detalle) {
		this.detalle = detalle;
	}

}
