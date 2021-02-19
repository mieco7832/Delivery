package com.delivery.models;

import java.util.Date;

public class Pedidos {

	private int id;
	private Date fecha;
	private String tipo;
	private int pedido;
	private String direccion;
	private String descripcion;
	private int motociclista;

	public Pedidos(int id, Date fecha, String tipo, int pedido, String direccion, String descripcion,
			int motociclista) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.tipo = tipo;
		this.pedido = pedido;
		this.direccion = direccion;
		this.descripcion = descripcion;
		this.motociclista = motociclista;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getPedido() {
		return pedido;
	}

	public void setPedido(int pedido) {
		this.pedido = pedido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getMotociclista() {
		return motociclista;
	}

	public void setMotociclista(int motociclista) {
		this.motociclista = motociclista;
	}

}
