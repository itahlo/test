package org.fiveware.test.service;

import java.util.List;

import org.fiveware.test.model.entity.Usuario;
import org.fiveware.test.model.repository.UsuarioRepository;

public class UsuarioService 
{
	
	public UsuarioService() {
	}
	
	public List<Usuario> usuariosEmpregados() {
		UsuarioRepository user = new UsuarioRepository();
		return user.usuariosEmpregados();
	}
	
    public void salvar(Usuario usr) {
    	
    	UsuarioRepository user = new UsuarioRepository();
    	user.salvar(usr);
    	
    }
    
}
