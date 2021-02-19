package com.delivery.models;

public class Equipo {
	
	private String placa;
	private String marca;
	private int sucursal;
	
	public Equipo(String placa, String marca, int sucursal) {
		super();
		this.placa = placa;
		this.marca = marca;
		this.sucursal = sucursal;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getSucursal() {
		return sucursal;
	}

	public void setSucursal(int sucursal) {
		this.sucursal = sucursal;
	}
	
}
