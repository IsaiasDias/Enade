package com.uniacademia.enade.dao;

import com.uniacademia.enade.model.EntidadeBase;
import com.uniacademia.enade.util.PersistenceUtil;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public abstract class GenericDAO<T extends EntidadeBase> implements Serializable{
    
    	private static final long serialVersionUID = 7805332224702440775L;
	private static final EntityManager em = getEM();

    public static EntityManager getEM() {
        return PersistenceUtil.getEntityManager();
    }

    public T buscar(Class<T> clazz, Integer id) {
        return em.find(clazz, id);
    }

    public List<T> buscarTodas(Class<T> clazz) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(clazz);
        query.from(clazz);
        return em.createQuery(query).getResultList();
    }

    public void remover(Class<T> clazz, Integer id) {
        T object = buscar(clazz, id);
        em.getTransaction().begin();
        if (!em.contains(object)) {
            object = em.merge(object);
        }
        em.remove(object);
        em.flush();
        em.getTransaction().commit();
    }

    public T atualizar(T objeto) {
        em.getTransaction().begin();
        try {
            objeto = em.merge(objeto);
            em.flush();
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
            em.flush();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public void removeAll(Class<T> clazz) {
        if(!em.getTransaction().isActive())
        	em.getTransaction().begin();
        String className = clazz.getSimpleName();
        Query query = em.createNativeQuery(String.format("delete from %s", className));
        query.executeUpdate();
        em.flush();
        em.getTransaction().commit();
    }
}
