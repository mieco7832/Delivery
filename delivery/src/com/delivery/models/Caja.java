package com.delivery.models;

import java.util.Date;

public class Caja {
	
	//Ruta
	private int id_destino;
	private Date fecha;
	private String estado;
	//Pedido
	private int id_factura;
	private String Pructo;
	private double total;
	private String destino;
	private String nombre_cajero;
	//Motorista
	private int id_motorista;
	private String unidad;
	private String nombre_motorista;
	
	public Caja(int id_destino, Date fecha, String estado, int id_factura, String pructo, double total, String destino,
			String nombre_cajero,int id_motorista ,String unidad, String nombre_motorista) {
		super();
		this.id_destino = id_destino;
		this.fecha = fecha;
		this.estado = estado;
		this.id_factura = id_factura;
		Pructo = pructo;
		this.total = total;
		this.destino = destino;
		this.nombre_cajero = nombre_cajero;
		this.id_motorista = id_motorista;
		this.unidad = unidad;
		this.nombre_motorista = nombre_motorista;
	}

	public int getId_destino() {
		return id_destino;
	}

	public void setId_destino(int id_destino) {
		this.id_destino = id_destino;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getId_factura() {
		return id_factura;
	}

	public void setId_factura(int id_factura) {
		this.id_factura = id_factura;
	}

	public String getPructo() {
		return Pructo;
	}

	public void setPructo(String pructo) {
		Pructo = pructo;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getNombre_cajero() {
		return nombre_cajero;
	}

	public void setNombre_cajero(String nombre_cajero) {
		this.nombre_cajero = nombre_cajero;
	}
	
	public int getId_motorista() {
		return id_motorista;
	}

	public void setId_motorista(int id_motorista) {
		this.id_motorista = id_motorista;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public String getNombre_motorista() {
		return nombre_motorista;
	}

	public void setNombre_motorista(String nombre_motorista) {
		this.nombre_motorista = nombre_motorista;
	}
	
}
