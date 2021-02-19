package com.delivery.models;

public class Usuario {

	private String id_personal;
	private int id_sucursal;
	private String rol;
	
	public Usuario(String id_personal, int id_sucursal,String rol) {
		super();
		this.id_personal = id_personal;
		this.id_sucursal = id_sucursal;
		this.rol = rol;
	}
	public String getId_personal() {
		return id_personal;
	}
	public void setId_personal(String id_personal) {
		this.id_personal = id_personal;
	}
	public int getId_sucursal() {
		return id_sucursal;
	}
	public void setId_sucursal(int id_sucursal) {
		this.id_sucursal = id_sucursal;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	
}
