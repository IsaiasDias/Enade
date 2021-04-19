package com.uniacademia.enade.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.uniacademia.enade.dao.TipoQuestaoDAO;
import com.uniacademia.enade.model.TipoQuestao;
import java.io.Serializable;

@Named
@ViewScoped
public class TipoQuestaoController implements Serializable {

	private static final long serialVersionUID = 8029729115141954217L;
	private List<TipoQuestao> tiposQuestoes = new ArrayList<>();
	private TipoQuestaoDAO dao = TipoQuestaoDAO.getInstance();

    public TipoQuestaoController() {
    	tiposQuestoes = dao.buscarTodas(TipoQuestao.class);
    }

    public void gravar(TipoQuestao tipoQuestao) {
        dao.atualizar(tipoQuestao);
        tiposQuestoes = dao.buscarTodas(TipoQuestao.class);
    }

    public void remover(TipoQuestao tipoQuestao) {
        dao.remover(TipoQuestao.class, tipoQuestao.getId());
        tiposQuestoes = dao.buscarTodas(TipoQuestao.class);
    }

    public List<TipoQuestao> getTiposQuestoes() {
        return tiposQuestoes;
    }

}
