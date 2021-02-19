package com.delivery.domain;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.repository.MotoristaImpl;
import com.delivery.repository.PersonalImpl;
import com.delivery.repository.RutaImpl;
import com.delivery.repository.SucursalImpl;
import com.delivery.entity.Motociclista;
import com.delivery.entity.Personal;
import com.delivery.entity.Ruta;
import com.delivery.entity.Sucursal;
import com.delivery.models.Pedidos;
import com.delivery.models.Perfiles;
import com.delivery.models.Usuario;

@Service
public class Marcar {

	@Autowired
	private RutaImpl rutaImpl;
	@Autowired
	private PersonalImpl personalImpl;
	@Autowired
	private SucursalImpl sucursalImpl;
	@Autowired
	private MotoristaImpl motoristaImpl;

	// Perfil
	public Perfiles getPerfil(Usuario us) {
		Perfiles caja = null;
		for (Personal personal : personalImpl.get()) {
			if (personal.getIdPersonal().equals(us.getId_personal()) && personal.getRol().equals("Motorista")) {
				for (Sucursal sucursal : sucursalImpl.get()) {
					if (sucursal.getIdSucursal() == us.getId_sucursal()) {
						caja = new Perfiles(" ", 0, " ",
								(personal.getNombrePersonal() + " " + personal.getApellidoPersonal()),
								personal.getRol(), "", sucursal.getNombreSuscursal(),
								sucursal.getUbicacion(), sucursal.getTelefeno());
					}
				}
			}
		}
		return caja;
	}
	
	// Listar Pedidos
	public List<Pedidos> pedidosByUser(String s) {
		List<Pedidos> pedidos = new ArrayList<>();
		for (Personal p : personalImpl.get()) {
			if (p.getIdPersonal().equals(s)) {
				for (Motociclista moto : motoristaImpl.get()) {
					moto.setPersonal(p);
					if (moto.getPersonal().getIdPersonal().equals(s)) {
						for (Ruta ruta : rutaImpl.get()) {
							if (ruta.getMotociclista().getPersonal().getIdPersonal().equals(s)) {}
							ruta.setMotociclista(moto);
							Pedidos pedido = new Pedidos(ruta.getIdRuta(), ruta.getFechaRuta(), ruta.getTipoMarcado(),
									ruta.getPedido().getIdPedido(), ruta.getPedido().getDireccion(),
									ruta.getPedido().getProducto(), ruta.getMotociclista().getIdMotociclista());
							pedidos.add(pedido);
						}
						return pedidos;
					}
				}
			}
		}
		return pedidos;
	}
	
	public void marcar(int i) {
		for (Ruta r : rutaImpl.get()) {
			if (r.getIdRuta() == i) {
				if (r.getTipoMarcado().equals("Asignado")) {
					Ruta ruta = new Ruta();
					ruta.setPedido(r.getPedido());
					ruta.setMotociclista(r.getMotociclista());
					ruta.setTipoMarcado("Salida");
					ruta.setFechaRuta(new Date());
					rutaImpl.create(ruta);
				} else {
					Ruta ruta = new Ruta();
					ruta.setPedido(r.getPedido());
					ruta.setMotociclista(r.getMotociclista());
					ruta.setTipoMarcado("Entrada");
					ruta.setFechaRuta(new Date());
					rutaImpl.create(ruta);
				}
			}
		}
	}

}
