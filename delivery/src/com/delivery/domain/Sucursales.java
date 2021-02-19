package com.delivery.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.entity.Motociclista;
import com.delivery.entity.Personal;
import com.delivery.entity.Sucursal;
import com.delivery.entity.Turno;
import com.delivery.entity.Unidad;
import com.delivery.models.Equipo;
import com.delivery.models.Perfiles;
import com.delivery.repository.MotoristaImpl;
import com.delivery.repository.PersonalImpl;
import com.delivery.repository.SucursalImpl;
import com.delivery.repository.TurnoImpl;
import com.delivery.repository.UnidadImpl;
import com.mysql.jdbc.PreparedStatement.ParseInfo;

@Service
public class Sucursales {

	@Autowired
	private PersonalImpl personalImpl;
	@Autowired
	private SucursalImpl sucursalImpl;
	@Autowired
	private TurnoImpl turnoImpl;
	@Autowired
	private UnidadImpl unidadImpl;
	@Autowired
	private MotoristaImpl motoristaImpl;

	public List<Perfiles> listaEmpleado(int i) {
		List<Perfiles> list = new ArrayList<>();
		for (Sucursal s : sucursalImpl.get()) {
			if (s.getIdSucursal() == i) {
				for (Personal p : personalImpl.get()) {
					for (Turno t : turnoImpl.get()) {
						if (p.getIdPersonal().equals(t.getIdPersonal())) {
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

	public Perfiles motoInf(String s) {
		Perfiles perfil = null;
		for (Motociclista m : motoristaImpl.get()) {
			if (m.getPersonal().getIdPersonal().equals(s)) {
				perfil = new Perfiles(m.getPersonal().getIdPersonal(), 0, m.getUnidad().getIdUnidad(),
						m.getPersonal().getNombrePersonal() + " " + m.getPersonal().getApellidoPersonal(),
						m.getPersonal().getRol(), m.getPersonal().getTurno().getIdTurno(), "", "", "");
			}
		}
		return perfil;
	}

	public Perfiles empleado(String s) {
		Perfiles perfil = null;
		List<Personal> list = this.personalImpl.get();
		List<Sucursal> sucursals = this.sucursalImpl.get();
		List<Turno> turnos = this.turnoImpl.get();
		String turno = "";
		for (Personal pers : list) {
			if (pers.getIdPersonal().equals(s)) {
				for (Turno t : turnos) {
					if (t.getIdPersonal().equals(s)) {
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

	public List<Perfiles> listarSucursales() {
		List<Perfiles> list = new ArrayList<>();
		List<Sucursal> sucursales = sucursalImpl.get();
		for (Sucursal sucursal : sucursales) {
			Perfiles perfil = new Perfiles("", sucursal.getIdSucursal(), "", "", "", "", sucursal.getNombreSuscursal(),
					"", "");
			list.add(perfil);
		}
		return list;
	}

	public List<Equipo> listaEquipo(int s) {
		try {
			List<Equipo> list = new ArrayList<>();
			Sucursal sucursal = null;
			for (Sucursal su : sucursalImpl.get()) {
				if (su.getIdSucursal() == s) {
					sucursal = su;
				}
			}
			
			for (Motociclista moto : motoristaImpl.get()) {
				Equipo eq = new Equipo(moto.getUnidad().getIdUnidad(), moto.getUnidad().getModelo(),
						sucursal.getIdSucursal());
				list.add(eq);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void ingresarEmpleado(String rol, String direccion, String dui, String nombre, String apellido,
			String usuario, String clave, int tienda, String placa, String marca, boolean propio) {
		Personal personal = new Personal();
		Sucursal sucursal = new Sucursal();
		Unidad unidad = new Unidad();
		Motociclista motociclista = new Motociclista();
		List<Sucursal> sucursales = sucursalImpl.get();
		for (Sucursal suc : sucursales) {
			if (suc.getIdSucursal() == tienda) {
				sucursal = suc;
			}
		}
		personal.setSucursal(sucursal);
		personal.setIdPersonal(dui);
		personal.setNombrePersonal(nombre);
		personal.setApellidoPersonal(apellido);
		personal.setNombreUsuario(usuario);
		personal.setClaveUsuario(clave);
		personal.setDireccionUsuario(direccion);
		personal.setRol(rol);
		personalImpl.create(personal);
		List<Unidad> unidades = unidadImpl.get();
		if (!placa.equals("")) {
			if (propio) {
				motociclista.setPoseeMoto("si");
				unidad.setIdUnidad(placa);
				unidad.setModelo(marca);
				unidad.setSucursal(sucursal);
				unidadImpl.create(unidad);
				for (Unidad u : unidades) {
					if (u.getIdUnidad().equals(placa)) {
						unidad = u;
					}
				}
			} else {
				motociclista.setPoseeMoto("no");
				for (Unidad u : unidades) {
					if (u.getIdUnidad().equals(placa)) {
						unidad = u;
					}
				}
			}
			motociclista.setPersonal(personal);
			motociclista.setUnidad(unidad);
			motoristaImpl.create(motociclista);
		}
		Turno turno = new Turno();
		turno.setIdPersonal(personal.getIdPersonal());
		turno.setPersonal(personal);
		turno.setIdTurno("Matutino");
		turnoImpl.create(turno);
		
	}
	
	public void nuevaUnidad(String placa, String modelo, int sucursal) {
		Sucursal id_sucursal = new Sucursal();
		Unidad unidad = new Unidad();
		for (Sucursal su : sucursalImpl.get()) {
			if (su.getIdSucursal() == sucursal) {
				id_sucursal = su;
			}
		}
		unidad.setSucursal(id_sucursal);
		unidad.setIdUnidad(placa);
		;
		unidad.setModelo(modelo);
		unidadImpl.create(unidad);
	}

}
