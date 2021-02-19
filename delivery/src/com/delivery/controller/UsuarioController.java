package com.delivery.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.delivery.domain.Administracion;
import com.delivery.models.Usuario;

@Controller
@RequestMapping("/")
@Scope("session")
public class UsuarioController {

	@Autowired
	private Administracion admin;
	ModelAndView mv = new ModelAndView();

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView toLogin() {
		mv.setViewName("view/login");
		return mv;
	}
	
	@RequestMapping(value = "home", method = RequestMethod.GET)
	public ModelAndView toHome() {
		mv.setViewName("view/home");
		return mv;
	}

	@RequestMapping(value = "sesion", method = RequestMethod.POST)
	public @ResponseBody ModelAndView setSesion(HttpServletRequest request,
			@RequestParam(value = "nombre_usuario") String usuario,
			@RequestParam(value = "clave_usuario") String clave) {
		Usuario us = admin.getUsuario(usuario, clave);
		if (us != null) {
			request.getSession().setAttribute("sesion_estado", "Activo");
			request.getSession().setAttribute("user", us);
			mv = this.toHome();
		} else {
			mv = this.toLogin();
		}
		return mv;
	}

	@RequestMapping(value = "out", method = RequestMethod.GET)
	public @ResponseBody ModelAndView outSesion(HttpServletRequest request) {
		request.getSession().setAttribute("sesion_estado", null);
		request.getSession().setAttribute("user", null);
		mv = this.toLogin();
		return mv;
	}
}
