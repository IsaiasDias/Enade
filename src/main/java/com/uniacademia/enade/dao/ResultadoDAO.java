package com.uniacademia.enade.dao;

import com.uniacademia.enade.model.Resultado;

public class ResultadoDAO extends GenericDAO<Resultado>{
     
    public static ResultadoDAO resultadoDAO;
    
    public static ResultadoDAO getInstance(){
        if(resultadoDAO == null){
            resultadoDAO = new ResultadoDAO();
        }
        return resultadoDAO;
    }
    
    private ResultadoDAO() {
        
    }
}
