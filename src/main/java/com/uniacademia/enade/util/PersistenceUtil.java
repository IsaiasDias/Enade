/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniacademia.enade.util;

import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.eclipse.persistence.sessions.Session;

public class PersistenceUtil {

    private static final String PERSISTENCE_UNIT_NAME = "ENADE";
    private static EntityManagerFactory factory;
    private static ThreadLocal<EntityManager> manager = new ThreadLocal<>();
    private static Session session;

    static {
        if (factory == null) {
            try {
                factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            } catch (Exception e) {
                Logger.getLogger("A criacao o do EntityManagerFactory falhou!");
                throw new ExceptionInInitializerError(e);
            }
        }
    }
    
    private PersistenceUtil() {
    	
    }

    public static EntityManager getEntityManager() {
        EntityManager em = manager.get();

        if (em == null) {
            em = factory.createEntityManager();
            manager.set(em);
        }
        return em;
    }

    public static void closeEntityManager() {
        EntityManager em = manager.get();

        if (em != null) {
            em.close();
        }
        manager.remove();
    }

    public static Session getSession() {
        if (session == null) {
            session = (Session) getEntityManager().getDelegate();
        }
        return session;
    }
}
