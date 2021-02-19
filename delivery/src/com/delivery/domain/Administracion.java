package com.delivery.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.entity.Personal;
import com.delivery.models.Usuario;
import com.delivery.repository.PersonalImpl;

@Service
public class Administracion {

	@Autowired
	private PersonalImpl personalImpl;
	
	public Usuario getUsuario(String usuario, String clave) {
		List<Personal> lista = personalImpl.get();
		Usuario us = null;
		for(Personal personal:lista) {
			if(personal.getNombreUsuario().equals(usuario) && personal.getClaveUsuario().equals(clave)) {
				us = new Usuario(personal.getIdPersonal(), personal.getSucursal().getIdSucursal(), personal.getRol());
			}
		}
		return us;
	}
	
}
