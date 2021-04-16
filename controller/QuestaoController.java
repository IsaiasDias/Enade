package com.uniacademia.enade.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.uniacademia.enade.dao.QuestaoDAO;
import com.uniacademia.enade.model.Questao;

@Named
@ViewScoped
public class QuestaoController {

	List<Questao> questoes = new ArrayList<>();
	QuestaoDAO dao = QuestaoDAO.getInstance();

    public QuestaoController() {
    	questoes = dao.buscarTodas(Questao.class);
    }

    public void gravar(Questao questao) {
        dao.atualizar(questao);
        questoes = dao.buscarTodas(Questao.class);
    }

    public void remover(Questao questao) {
        dao.remover(questao);
        questoes = dao.buscarTodas(Questao.class);
    }

    public List<Questao> getQuestoes() {
        return questoes;
    }

}
