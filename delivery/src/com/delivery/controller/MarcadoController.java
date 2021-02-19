package com.delivery.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.delivery.domain.Marcar;
import com.delivery.models.Usuario;

@Controller
@RequestMapping("/")
public class MarcadoController {
	
	@Autowired
	private Marcar marca;
	ModelAndView mv = new ModelAndView();
	
	@RequestMapping(value = "marcado", method = RequestMethod.GET)
	public ModelAndView toMarcado(HttpSession sesion) {
		Usuario us = (Usuario)sesion.getAttribute("user");
		mv.addObject("list_pedidos", marca.pedidosByUser(us.getId_personal()));
		mv.addObject("perfil", marca.getPerfil(us));
		mv.setViewName("view/marcado");
		return mv;
	}
	
	@RequestMapping(value = "marcar", method = RequestMethod.POST)
	public @ResponseBody ModelAndView seleccionarPedido(HttpSession sesion,@RequestParam(value = "pedido") int i) {
		marca.marcar(i);
		return this.toMarcado(sesion);
	}
	
}
