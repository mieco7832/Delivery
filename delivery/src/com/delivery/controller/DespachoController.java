package com.delivery.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.delivery.domain.Despacho;
import com.delivery.models.Caja;
import com.delivery.models.Usuario;

@Controller
@RequestMapping("/")
public class DespachoController {

	@Autowired
	private Despacho despacho;
	ModelAndView mv = new ModelAndView();

	@RequestMapping(value = "despacho", method = RequestMethod.GET)
	public @ResponseBody ModelAndView toDespacho(HttpSession sesion) {
		try { 
			Usuario us = (Usuario)sesion.getAttribute("user");
			mv.addObject("perfil", despacho.getPerfil(us));
			mv.addObject("lista_empleado", despacho.listaEmpleado(us.getId_sucursal()));
			mv.setViewName("view/despacho");
			return mv;
		} catch (Exception e) {
			e.printStackTrace();
			mv.setViewName("index");
			return mv;
		}
	}

	@RequestMapping(value = "regs_ruta", method = RequestMethod.POST)
	public @ResponseBody ModelAndView setRuta(HttpSession sesion,
			@RequestParam(value = "producto") String producto, @RequestParam(value = "total") double total,
			@RequestParam(value = "destino") String destino,
			@RequestParam(value = "id_motorista") String id_motorista) {
		Usuario us = (Usuario)sesion.getAttribute("user");
		despacho.setRutas(producto, total, destino, us.getId_personal(), id_motorista);
		return this.toDespacho(sesion);
	}

}
