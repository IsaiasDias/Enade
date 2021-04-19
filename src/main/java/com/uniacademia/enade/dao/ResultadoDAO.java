package com.uniacademia.enade.dao;

import com.uniacademia.enade.model.Resultado;

public class ResultadoDAO extends GenericoDAO<Resultado> {

	private static final long serialVersionUID = -3463141002587296881L;
	private static ResultadoDAO resultadoDAO;

    public static ResultadoDAO getInstance() {
        if (resultadoDAO == null) {
            resultadoDAO = new ResultadoDAO();
        }
        return resultadoDAO;
    }
    
    private ResultadoDAO (){
        
    }

}
