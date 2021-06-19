package com.uniacademia.enade.dao;

import com.uniacademia.enade.model.Questao;

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
    
}
