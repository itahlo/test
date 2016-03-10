package org.fiveware.test.model.repository;

import java.util.List;

import org.fiveware.test.model.entity.Usuario;
import org.fiveware.test.model.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class UsuarioRepository extends RepositoryBase<Usuario> {
	
	public List<Usuario> usuariosEmpregados() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("empregado", true));
		List<Usuario> lista = criteria.list();
		return lista;
	}
}
