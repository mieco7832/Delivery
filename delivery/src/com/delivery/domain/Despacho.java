package com.delivery.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.entity.Motociclista;
import com.delivery.entity.Pedido;
import com.delivery.entity.Personal;
import com.delivery.entity.Ruta;
import com.delivery.entity.Sucursal;
import com.delivery.entity.Turno;
import com.delivery.entity.Unidad;
import com.delivery.models.Caja;
import com.delivery.models.Pedidos;
import com.delivery.models.Perfiles;
import com.delivery.models.Usuario;
import com.delivery.repository.MotoristaImpl;
import com.delivery.repository.PedidoImpl;
import com.delivery.repository.PersonalImpl;
import com.delivery.repository.RutaImpl;
import com.delivery.repository.SucursalImpl;
import com.delivery.repository.TurnoImpl;
import com.delivery.repository.UnidadImpl;

@Service
public class Despacho {

	@Autowired
	private RutaImpl rutaImpl;
	@Autowired
	private PedidoImpl pedidoImpl;
	@Autowired
	private MotoristaImpl motoristaImpl;
	@Autowired
	private PersonalImpl personalImpl;
	@Autowired
	private SucursalImpl sucursalImpl;
	@Autowired
	private TurnoImpl turnoImpl;
	@Autowired
	private UnidadImpl unidadImpl;

	// Perfil
	public Perfiles getPerfil(Usuario us) {
		Perfiles perfil = null;
		List<Personal> list = this.personalImpl.get();
		List<Sucursal> sucursals = this.sucursalImpl.get();
		List<Turno> turnos = this.turnoImpl.get();
		String turno = "Matutino";
		for (Personal pers : list) {
			if (pers.getIdPersonal().equals(us.getId_personal())) {
				for (Turno t : turnos) {
					if (t.getIdPersonal().equals(us.getId_personal())) {
						turno = t.getIdTurno();
					}
				}
				String nombre = pers.getNombrePersonal() + " " + pers.getApellidoPersonal();
				perfil = new Perfiles(pers.getIdPersonal(),
						sucursals.get(pers.getSucursal().getIdSucursal() - 1).getIdSucursal(), "", nombre,
						pers.getRol(), turno,
						sucursals.get(pers.getSucursal().getIdSucursal() - 1).getNombreSuscursal(),
						sucursals.get(pers.getSucursal().getIdSucursal() - 1).getUbicacion(),
						sucursals.get(pers.getSucursal().getIdSucursal() - 1).getTelefeno());
			}
		}
		return perfil;
	}

	// Asignar Rutas
	public void setRutas(String producto, double total, String destino, String id_cajero, String id_motorista) {
		List<Motociclista> motoristas = motoristaImpl.get();
		Motociclista motorista = new Motociclista();
		for (Motociclista motociclista : motoristas) {
			if (motociclista.getPersonal().getIdPersonal().equals(id_motorista)) {
				motorista = motociclista;
			}
		}
		List<Pedido> pedidos = pedidoImpl.get();
		Pedido cajero = new Pedido();
		cajero.setProducto(producto);
		cajero.setPrecio(total);
		cajero.setDireccion(destino);
		List<Personal> personas = personalImpl.get();
		for (Personal personal : personas) {
			if (personal.getIdPersonal().equals(id_cajero)) {
				cajero.setPersonal(personal);
			}
		}
		pedidoImpl.create(cajero);
		for (Pedido pedido : pedidos) {
			if (pedido.getPersonal().getIdPersonal().equals(cajero.getPersonal().getIdPersonal())) {
				cajero = pedido;
			}
		}
		Ruta ruta = new Ruta();
		ruta.setMotociclista(motorista);
		ruta.setPedido(cajero);
		ruta.setTipoMarcado("Asignado");
		ruta.setFechaRuta(new Date());
		rutaImpl.create(ruta);

	}

	// Lista de motoristas Disponibles
	public List<Perfiles> listaEmpleado(int i) {
		List<Perfiles> list = new ArrayList<>();
		for (Sucursal s : sucursalImpl.get()) {
			if (s.getIdSucursal() == i) {
				for (Personal p : personalImpl.get()) {
					for (Turno t : turnoImpl.get()) {
						if (p.getIdPersonal().equals(t.getIdPersonal()) && p.getRol().equals("Motorista")) {
							Perfiles perfil = new Perfiles(p.getIdPersonal(), s.getIdSucursal(), "",
									p.getNombrePersonal() + " " + p.getApellidoPersonal(), p.getRol(), t.getIdTurno(),
									s.getNombreSuscursal(), s.getNombreSuscursal(), s.getUbicacion());
							list.add(perfil);
						}
					}
				}
			}
		}
		return list;
	}
}
