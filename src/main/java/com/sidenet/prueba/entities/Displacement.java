package com.sidenet.prueba.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name = "displacements")
public class Displacement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@NotBlank
	@Column(name = "plaque")
	@Size(max = 10)
	private String plaque;
	
	@NotBlank
	@Column(name = "origin")
	private String origin;
	
	@NotBlank
	@Column(name = "destination")
	private String destination;
	
	@NotBlank
	@Column(name = "origin_date")
	private Date origin_date;
	
	@NotBlank
	@Column(name = "destination_date")
	private Date destination_date;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlaque() {
		return plaque;
	}

	public void setPlaque(String plaque) {
		this.plaque = plaque;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getOrigin_date() {
		return origin_date;
	}

	public void setOrigin_date(Date origin_date) {
		this.origin_date = origin_date;
	}

	public Date getDestination_date() {
		return destination_date;
	}

	public void setDestination_date(Date destination_date) {
		this.destination_date = destination_date;
	}
	
	
}