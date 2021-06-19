package com.uniacademia.enade.dao;

import com.uniacademia.enade.model.Prova;

public class ProvaDAO extends GenericDAO<Prova>{
    
   public static ProvaDAO provaDAO;
    
    public static ProvaDAO getInstance(){
        if(provaDAO == null){
            provaDAO = new ProvaDAO();
        }
        return provaDAO;
    }
    
    private ProvaDAO() {
        
    }  
    
}
