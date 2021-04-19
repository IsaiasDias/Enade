package com.uniacademia.enade.dao;

import com.uniacademia.enade.model.Prova;

public class ProvaDAO extends GenericoDAO<Prova> {

	private static final long serialVersionUID = 7298633040289116662L;
	private static ProvaDAO provaDAO;

    public static ProvaDAO getInstance() {
        if (provaDAO == null) {
            provaDAO = new ProvaDAO();
        }
        return provaDAO;
    }
    
    private ProvaDAO() {
    	
    }


}