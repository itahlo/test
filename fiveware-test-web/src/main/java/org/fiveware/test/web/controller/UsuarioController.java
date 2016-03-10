package org.fiveware.test.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.fiveware.test.model.entity.Skills;
import org.fiveware.test.model.entity.Usuario;
import org.fiveware.test.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UsuarioController {
	
	@RequestMapping(value = "/usuariosEmpregados", method = RequestMethod.POST)
	public @ResponseBody List<Usuario> usuariosEmpregados(HttpServletRequest request) {
		
		UsuarioService us = new UsuarioService();
		List<Usuario> list = us.usuariosEmpregados();
		
		return list;
	}
	
	@RequestMapping(value = "/cadastrarUsuario", method = RequestMethod.POST)
	public @ResponseBody String cadastrarUsuario(HttpServletRequest request) {
		
		Usuario user = new Usuario();
		user.setNome(request.getParameter("nome"));
		user.setEmail(request.getParameter("email"));
		user.setEmpregado(new Boolean(request.getParameter("empregado")).booleanValue());
		user.setSexo(request.getParameter("sexo"));
		
		String[] skillsCheck = request.getParameterValues("skillcheck");
		
		List<Skills> skillsList = new ArrayList<>();
		if(skillsCheck != null && skillsCheck.length > 0)
		for(String s : skillsCheck) {
			Skills skill = new Skills();
			skill.setId(Integer.parseInt(s));
			skillsList.add(skill);
		}
		user.setSkills(skillsList);
		
		UsuarioService us = new UsuarioService();
		us.salvar(user);
		
		return "{\"mensagem\":\"Usuario cadastrado!\"}";
		
	}
}
