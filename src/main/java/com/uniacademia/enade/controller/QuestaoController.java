package com.uniacademia.enade.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.uniacademia.enade.dao.QuestaoDAO;
import com.uniacademia.enade.model.Questao;
import java.io.Serializable;

@Named
@ViewScoped
public class QuestaoController implements Serializable {

	private static final long serialVersionUID = 8463908859317136455L;
	private List<Questao> questoes = new ArrayList<>();
	private QuestaoDAO dao = QuestaoDAO.getInstance();

    public QuestaoController() {
    	questoes = dao.buscarTodas(Questao.class);
    }

    public void gravar(Questao questao) {
        dao.atualizar(questao);
        questoes = dao.buscarTodas(Questao.class);
    }

    public void remover(Questao questao) {
        dao.remover(Questao.class, questao.getId());
        questoes = dao.buscarTodas(Questao.class);
    }

    public List<Questao> getQuestoes() {
        return questoes;
    }

}
