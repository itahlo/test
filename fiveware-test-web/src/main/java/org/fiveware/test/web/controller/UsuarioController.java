package org.fiveware.test.web.controller;

import org.fiveware.test.model.entity.Usuario;
import org.fiveware.test.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UsuarioController {
	
//	@RequestMapping("/")
//	public String inicializa(){
//		return "index";
//	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	@ResponseBody
	public Usuario testeUsuario() {

		UsuarioService us = new UsuarioService();
		
		
		return us.exibir();
	}
	
	@RequestMapping(value = "/cadastrarUsuario", method = RequestMethod.POST)
	public @ResponseBody Usuario cadastrarUsuario(@ModelAttribute(value="usuario") Usuario user) {
		
		UsuarioService us = new UsuarioService();
		us.cadastrar();
		
		return user;
		
	}
}
