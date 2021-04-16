package com.uniacademia.enade.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.uniacademia.enade.dao.TipoQuestaoDAO;
import com.uniacademia.enade.model.TipoQuestao;

@Named
@ViewScoped
public class TipoQuestaoController {

	List<TipoQuestao> tiposQuestoes = new ArrayList<>();
	TipoQuestaoDAO dao = TipoQuestaoDAO.getInstance();

    public TipoQuestaoController() {
    	tiposQuestoes = dao.buscarTodas(TipoQuestao.class);
    }

    public void gravar(TipoQuestao tipoQuestao) {
        dao.atualizar(tipoQuestao);
        tiposQuestoes = dao.buscarTodas(TipoQuestao.class);
    }

    public void remover(TipoQuestao tipoQuestao) {
        dao.remover(tipoQuestao);
        tiposQuestoes = dao.buscarTodas(TipoQuestao.class);
    }

    public List<TipoQuestao> getTiposQuestoes() {
        return tiposQuestoes;
    }

}
