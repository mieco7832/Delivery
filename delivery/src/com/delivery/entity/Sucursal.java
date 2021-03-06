package com.delivery.entity;
// Generated 07-15-2020 03:28:48 PM by Hibernate Tools 5.2.12.Final

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Sucursal generated by hbm2java
 */
@Entity
@Table(name = "sucursal", catalog = "delivery")
public class Sucursal implements java.io.Serializable {

	private Integer idSucursal;
	private String nombreSuscursal;
	private String ubicacion;
	private String telefeno;
	private List<Personal> personals = new ArrayList<Personal>(0);
	private List<Unidad> unidads = new ArrayList<Unidad>(0);

	public Sucursal() {
	}

	public Sucursal(String ubicacion, String telefeno) {
		this.ubicacion = ubicacion;
		this.telefeno = telefeno;
	}

	public Sucursal(String nombreSuscursal, String ubicacion, String telefeno, List<Personal> personals,
			List<Unidad> unidads) {
		this.nombreSuscursal = nombreSuscursal;
		this.ubicacion = ubicacion;
		this.telefeno = telefeno;
		this.personals = personals;
		this.unidads = unidads;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_sucursal", unique = true, nullable = false)
	public Integer getIdSucursal() {
		return this.idSucursal;
	}

	public void setIdSucursal(Integer idSucursal) {
		this.idSucursal = idSucursal;
	}

	@Column(name = "nombre_suscursal", length = 50)
	public String getNombreSuscursal() {
		return this.nombreSuscursal;
	}

	public void setNombreSuscursal(String nombreSuscursal) {
		this.nombreSuscursal = nombreSuscursal;
	}

	@Column(name = "ubicacion", nullable = false, length = 150)
	public String getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	@Column(name = "telefeno", nullable = false, length = 9)
	public String getTelefeno() {
		return this.telefeno;
	}

	public void setTelefeno(String telefeno) {
		this.telefeno = telefeno;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sucursal")
	public List<Personal> getPersonals() {
		return this.personals;
	}

	public void setPersonals(List<Personal> personals) {
		this.personals = personals;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sucursal")
	public List<Unidad> getUnidads() {
		return this.unidads;
	}

	public void setUnidads(List<Unidad> unidads) {
		this.unidads = unidads;
	}

}
