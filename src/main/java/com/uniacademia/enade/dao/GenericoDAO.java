package com.uniacademia.enade.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import com.uniacademia.enade.model.EntidadeBase;
import com.uniacademia.enade.util.PersistenceUtil;

public abstract class GenericoDAO<T extends EntidadeBase>{
	
	private static EntityManager em = getEM();
	
	public static EntityManager getEM () {
		return PersistenceUtil.getEntityManager();
	}
	
	@SuppressWarnings("unchecked")
	public T buscar(Class<T> clazz , Integer id) {
		Query query = em.createQuery("select p from :Class p where p.Id :id");
		query.setParameter("Class", clazz);
		query.setParameter("Id", id);
		List<T> classe = query.getResultList();
		if (classe != null && !classe.isEmpty()) {
			return classe.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<T> buscarTodas(Class<T> clazz) {
		Query query = em.createQuery("select c from :Class c");
		query.setParameter("Class", clazz);
		return query.getResultList();
	}

	public void remover(T object) {
		em.getTransaction().begin();
		if (!em.contains(object)) {
			object = em.merge(object);
		}
		em.remove(object);
		em.getTransaction().commit();
	}

	public T atualizar(T objeto) {
		em.getTransaction().begin();
		try {
			objeto = em.merge(objeto);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		return objeto;
	}

	public void persistir(T object) {
		em.getTransaction().begin();
		try {
			em.persist(object);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

	public void removeAll(Class<T> clazz) {
		em.getTransaction().begin();
		Query query = em.createQuery("delete from :Class");
		query.setParameter("Class", clazz);
		query.executeUpdate();
		em.getTransaction().commit();
	}

}
