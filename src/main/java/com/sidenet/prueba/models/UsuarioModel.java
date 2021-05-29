package com.sidenet.prueba.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UsuarioModel {
	private int id;
	private String username;
	private String fullName;
	@JsonIgnore
	private String password;

	public UsuarioModel() {
	}

	public UsuarioModel(int id, String username, String password, String fullName) {
		this.id = id;
		this.username = username;
		this.fullName = fullName;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

}
