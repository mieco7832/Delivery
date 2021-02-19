package com.delivery.models;

public class Perfiles {
	
	private String id_per;
	private int id_suc;
	private String id_unidad;
	
	private String nombre_per;
	private String rol;
	private String turno;
	
	private String nombre_suc;
	private String ubicacion;
	private String telefono;

	public Perfiles(String id_per, int id_suc, String id_unidad, String nombre_per, String rol, String turno,
			String nombre_suc, String ubicacion, String telefono) {
		super();
		this.id_per = id_per;
		this.id_suc = id_suc;
		this.id_unidad = id_unidad;
		this.nombre_per = nombre_per;
		this.rol = rol;
		this.turno = turno;
		this.nombre_suc = nombre_suc;
		this.ubicacion = ubicacion;
		this.telefono = telefono;
	}

	public String getId_per() {
		return id_per;
	}

	public void setId_per(String id_per) {
		this.id_per = id_per;
	}

	public int getId_suc() {
		return id_suc;
	}

	public void setId_suc(int id_suc) {
		this.id_suc = id_suc;
	}

	public String getId_unidad() {
		return id_unidad;
	}

	public void setId_unidad(String id_unidad) {
		this.id_unidad = id_unidad;
	}

	public String getNombre_per() {
		return nombre_per;
	}

	public void setNombre_per(String nombre_per) {
		this.nombre_per = nombre_per;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public String getNombre_suc() {
		return nombre_suc;
	}

	public void setNombre_suc(String nombre_suc) {
		this.nombre_suc = nombre_suc;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
}
