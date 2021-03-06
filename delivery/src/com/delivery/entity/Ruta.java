package com.delivery.entity;
// Generated 07-15-2020 03:28:48 PM by Hibernate Tools 5.2.12.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Ruta generated by hbm2java
 */
@Entity
@Table(name = "ruta", catalog = "delivery")
public class Ruta implements java.io.Serializable {

	private Integer idRuta;
	private Motociclista motociclista;
	private Pedido pedido;
	private Date fechaRuta;
	private String tipoMarcado;

	public Ruta() {
	}

	public Ruta(Motociclista motociclista, Pedido pedido) {
		this.motociclista = motociclista;
		this.pedido = pedido;
	}

	public Ruta(Motociclista motociclista, Pedido pedido, Date fechaRuta, String tipoMarcado) {
		this.motociclista = motociclista;
		this.pedido = pedido;
		this.fechaRuta = fechaRuta;
		this.tipoMarcado = tipoMarcado;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_ruta", unique = true, nullable = false)
	public Integer getIdRuta() {
		return this.idRuta;
	}

	public void setIdRuta(Integer idRuta) {
		this.idRuta = idRuta;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_motociclista", nullable = false)
	public Motociclista getMotociclista() {
		return this.motociclista;
	}

	public void setMotociclista(Motociclista motociclista) {
		this.motociclista = motociclista;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_pedido", nullable = false)
	public Pedido getPedido() {
		return this.pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_ruta", length = 19)
	public Date getFechaRuta() {
		return this.fechaRuta;
	}

	public void setFechaRuta(Date fechaRuta) {
		this.fechaRuta = fechaRuta;
	}

	@Column(name = "tipo_marcado", length = 9)
	public String getTipoMarcado() {
		return this.tipoMarcado;
	}

	public void setTipoMarcado(String tipoMarcado) {
		this.tipoMarcado = tipoMarcado;
	}

}
