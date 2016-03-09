package org.fiveware.test.model.dao;

import org.fiveware.test.model.entity.Usuario;
import org.fiveware.test.model.util.HibernateUtil;
import org.hibernate.Session;

public class UsuarioDao {
	public void salvar() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Usuario user = new Usuario();
		user.setNome("italo");
		user.setEmail("italo.santss");
		user.setEmpregado(Boolean.TRUE);
		user.setSexo("MASCULINO");
		
		session.save(user);
		
		session.getTransaction().commit();
	}
}
