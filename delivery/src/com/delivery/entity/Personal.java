package com.delivery.entity;
// Generated 07-15-2020 03:28:48 PM by Hibernate Tools 5.2.12.Final

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Personal generated by hbm2java
 */
@Entity
@Table(name = "personal", catalog = "delivery")
public class Personal implements java.io.Serializable {

	private String idPersonal;
	private Sucursal sucursal;
	private String nombrePersonal;
	private String apellidoPersonal;
	private String nombreUsuario;
	private String claveUsuario;
	private String direccionUsuario;
	private String rol;
	private Turno turno;
	private List<Pedido> pedidos = new ArrayList<Pedido>(0);
	private List<Motociclista> motociclistas = new ArrayList<Motociclista>(0);

	public Personal() {
	}

	public Personal(String idPersonal, Sucursal sucursal, String nombrePersonal, String apellidoPersonal,
			String nombreUsuario, String claveUsuario, String direccionUsuario) {
		this.idPersonal = idPersonal;
		this.sucursal = sucursal;
		this.nombrePersonal = nombrePersonal;
		this.apellidoPersonal = apellidoPersonal;
		this.nombreUsuario = nombreUsuario;
		this.claveUsuario = claveUsuario;
		this.direccionUsuario = direccionUsuario;
	}

	public Personal(String idPersonal, Sucursal sucursal, String nombrePersonal, String apellidoPersonal,
			String nombreUsuario, String claveUsuario, String direccionUsuario, String rol, Turno turno,
			List<Pedido> pedidos, List<Motociclista> motociclistas) {
		this.idPersonal = idPersonal;
		this.sucursal = sucursal;
		this.nombrePersonal = nombrePersonal;
		this.apellidoPersonal = apellidoPersonal;
		this.nombreUsuario = nombreUsuario;
		this.claveUsuario = claveUsuario;
		this.direccionUsuario = direccionUsuario;
		this.rol = rol;
		this.turno = turno;
		this.pedidos = pedidos;
		this.motociclistas = motociclistas;
	}

	@Id

	@Column(name = "id_personal", unique = true, nullable = false, length = 10)
	public String getIdPersonal() {
		return this.idPersonal;
	}

	public void setIdPersonal(String idPersonal) {
		this.idPersonal = idPersonal;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_sucursal", nullable = false)
	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	@Column(name = "nombre_personal", nullable = false, length = 20)
	public String getNombrePersonal() {
		return this.nombrePersonal;
	}

	public void setNombrePersonal(String nombrePersonal) {
		this.nombrePersonal = nombrePersonal;
	}

	@Column(name = "apellido_personal", nullable = false, length = 20)
	public String getApellidoPersonal() {
		return this.apellidoPersonal;
	}

	public void setApellidoPersonal(String apellidoPersonal) {
		this.apellidoPersonal = apellidoPersonal;
	}

	@Column(name = "nombre_usuario", nullable = false, length = 20)
	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	@Column(name = "clave_usuario", nullable = false, length = 16)
	public String getClaveUsuario() {
		return this.claveUsuario;
	}

	public void setClaveUsuario(String claveUsuario) {
		this.claveUsuario = claveUsuario;
	}

	@Column(name = "direccion_usuario", nullable = false, length = 50)
	public String getDireccionUsuario() {
		return this.direccionUsuario;
	}

	public void setDireccionUsuario(String direccionUsuario) {
		this.direccionUsuario = direccionUsuario;
	}

	@Column(name = "rol", length = 10)
	public String getRol() {
		return this.rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "personal")
	public Turno getTurno() {
		return this.turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personal")
	public List<Pedido> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personal")
	public List<Motociclista> getMotociclistas() {
		return this.motociclistas;
	}

	public void setMotociclistas(List<Motociclista> motociclistas) {
		this.motociclistas = motociclistas;
	}

}