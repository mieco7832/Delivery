package com.delivery.controller;

import java.io.IOException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.delivery.domain.Sucursales;
import com.delivery.models.Perfiles;
import com.delivery.models.Usuario;
import com.google.gson.*;

@Controller
@RequestMapping("/")
public class SucursalController {

	@Autowired
	private Sucursales sucursales;
	ModelAndView mv = new ModelAndView();

	@RequestMapping(value = "perfil", method = RequestMethod.GET)
	public ModelAndView toPerfil(HttpSession sesion) {
		Usuario us = (Usuario) sesion.getAttribute("user");
		mv.addObject("listaPersonal", sucursales.listaEmpleado(us.getId_sucursal()));
		mv.addObject("listaSucursal", sucursales.listarSucursales());
		mv.addObject("supervisor", sucursales.empleado(us.getId_personal()));
		mv.addObject("equipos", sucursales.listaEquipo(us.getId_sucursal()));
		mv.setViewName("view/sucursal");
		return mv;
	}

	@RequestMapping(value = "unids", method = RequestMethod.POST)
	public @ResponseBody String getUnidades(HttpSession sesion) {
		Usuario us = (Usuario) sesion.getAttribute("user");
		String json = new Gson().toJson(sucursales.listaEquipo(us.getId_sucursal()));
		return json;
	}
	
	@RequestMapping(value = "getInf", method = RequestMethod.POST)
	public @ResponseBody Perfiles getInfo(@RequestParam(value = "inf") String inf) {
		return sucursales.motoInf(inf);
	}
	
	@RequestMapping(value = "nunid", method = RequestMethod.POST)
	public @ResponseBody ModelAndView getUnidad(HttpSession sesion, @RequestParam(value = "placa_unidad") String placa,
			@RequestParam(value = "modelo_unidad") String modelo) {
		try {
			Usuario us = (Usuario) sesion.getAttribute("user");
			sucursales.nuevaUnidad(placa, modelo, us.getId_sucursal());
			mv = this.toPerfil(sesion);
			return mv;
		} catch (Exception e) {
			e.printStackTrace();
			mv = this.toPerfil(sesion);
			return mv;
		}
	}
	
	@RequestMapping(value = "regs", method = RequestMethod.POST)
	public @ResponseBody ModelAndView getPerfil(HttpSession sesion, @RequestParam(value = "dui") String dui,
			@RequestParam(value = "nombre") String nombre, @RequestParam(value = "apellido") String apellido,
			@RequestParam(value = "usuario") String usuario, @RequestParam(value = "direccion") String direccion,
			@RequestParam(value = "pass") String pass, @RequestParam(value = "rol") String rol,
			@RequestParam(value = "unidad", required = false) boolean unidad, @RequestParam(value = "moto") String moto,
			@RequestParam(value = "marca", required = false) String marca,
			@RequestParam(value = "sucursal") int sucursal) throws IOException {
		try {
			sucursales.ingresarEmpleado(rol, direccion, dui, nombre, apellido, usuario, pass, sucursal, moto, marca,
					unidad);
			mv = this.toPerfil(sesion);
			return mv;
		} catch (Exception e) {
			mv = this.toPerfil(sesion);
			e.printStackTrace();
			return mv;
		}
	}

}
