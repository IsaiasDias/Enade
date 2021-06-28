package com.uniacademia.enade.dao;

import com.uniacademia.enade.model.Resultado;
import java.util.List;

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
    
    public List<Resultado> findResultadosUsuario(Integer idUsuario) {
        return em.createNamedQuery("Resultado.findByIdUsuario", Resultado.class)
                .setParameter("idUsuario", idUsuario).getResultList();
    }
    
    public List<Resultado> findUltimosDezResultados() {
        return em.createQuery("from Resultado r ORDER BY r.idResultado DESC", Resultado.class).setMaxResults(10).getResultList();
    }
}
