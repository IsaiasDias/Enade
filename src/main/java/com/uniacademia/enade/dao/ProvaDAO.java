package com.uniacademia.enade.dao;

import com.uniacademia.enade.model.Prova;
import java.util.Date;

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
    
    public Prova findUltimaProvaAtiva(Integer idAluno) {
        final String jpql = " SELECT p FROM Prova p "
                + " LEFT JOIN p.resultadoList r "
                + " WHERE p.dataProva >= :dataProva AND (r.usuarioidUsuario IS NULL OR r.usuarioidUsuario.idUsuario <> :idAluno)";
        return (Prova) findSingleResult(em.createQuery(jpql)
                .setParameter("dataProva", new Date())
                .setParameter("idAluno", idAluno));
    }
    
}
