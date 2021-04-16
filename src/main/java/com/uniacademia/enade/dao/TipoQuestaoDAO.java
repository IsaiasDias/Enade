package com.uniacademia.enade.dao;

import com.uniacademia.enade.model.TipoQuestao;

public class TipoQuestaoDAO extends GenericoDAO<TipoQuestao> {
    
	private static TipoQuestaoDAO tipoQuestaoDAO;

    public static TipoQuestaoDAO getInstance() {
        if (tipoQuestaoDAO == null) {
            tipoQuestaoDAO = new TipoQuestaoDAO();
        }
        return tipoQuestaoDAO;
    }
    
    private TipoQuestaoDAO () {
    
    }

}
