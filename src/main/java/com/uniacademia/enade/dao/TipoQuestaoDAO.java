package com.uniacademia.enade.dao;

import com.uniacademia.enade.model.TipoQuestao;

public class TipoQuestaoDAO extends GenericoDAO<TipoQuestao> {

	private static final long serialVersionUID = -5593303158572876104L;
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
