package org.fiveware.test.service;

import org.fiveware.test.model.dao.UsuarioDao;
import org.fiveware.test.model.entity.Usuario;

/**
 * Hello world!
 *
 */
public class UsuarioService 
{
	
	public UsuarioService() {
	}
	
    public void cadastrar() {
    	
    	UsuarioDao userDao = new UsuarioDao();
    	userDao.salvar();
    	
    }
    
    public Usuario exibir() {
    	
    	Usuario user = new Usuario();
    	user.setNome("Italo Santana");
    	user.setEmail("italo.santss@gmail.com");
    	
    	return user;
    }
    
    
}
