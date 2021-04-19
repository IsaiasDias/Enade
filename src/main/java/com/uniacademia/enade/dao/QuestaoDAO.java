package com.uniacademia.enade.dao;

import com.uniacademia.enade.model.Questao;

public class QuestaoDAO extends GenericoDAO<Questao> {

	private static final long serialVersionUID = -2370230064965053787L;
	private static QuestaoDAO questaoDAO;
    
    public static QuestaoDAO getInstance() {
        if (questaoDAO == null) {
            questaoDAO = new QuestaoDAO();
        }
        return questaoDAO;
    }
    
    private QuestaoDAO() {
    	
    }

}
