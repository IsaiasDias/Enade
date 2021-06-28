package com.uniacademia.enade.dao;

import com.uniacademia.enade.model.Questao;
import java.util.List;

public class QuestaoDAO extends GenericDAO<Questao> {
     
    public static QuestaoDAO questaoDAO;
    
    public static QuestaoDAO getInstance(){
        if(questaoDAO == null){
            questaoDAO = new QuestaoDAO();
        }
        return questaoDAO;
    }
    
    private QuestaoDAO() {
        
    }
    
    public List<Questao> findQuestoesAtivas() {
        return em.createNamedQuery("Questao.findByEstadoQuestao", Questao.class)
                .setParameter("estadoQuestao", true).getResultList();
    }
}
