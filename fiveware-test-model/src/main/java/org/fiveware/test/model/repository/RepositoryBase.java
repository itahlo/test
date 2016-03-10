package org.fiveware.test.model.repository;

import org.fiveware.test.model.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public abstract class RepositoryBase<T> {
	
	public void salvar(T entidade) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			session.save(entidade);
			session.getTransaction().commit();
		}catch(HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
	}
	
	public void apagar(T entidade) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.delete(entidade);
			session.getTransaction().commit();
		}catch(HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
	}
}
