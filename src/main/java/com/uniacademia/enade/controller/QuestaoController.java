package com.uniacademia.enade.controller;

import com.uniacademia.enade.dao.QuestaoDAO;
import com.uniacademia.enade.model.Questao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class QuestaoController implements Serializable {
    
    private Questao questao;
    private List<Questao> questoes;
    
    public QuestaoController(){
        questoes = new ArrayList<>();
        questoes = QuestaoDAO.getInstance().buscarTodas(Questao.class);
        questao = new Questao();
    }
    
    public void gravar(){
        QuestaoDAO.getInstance().persistir(questao);
        questoes = QuestaoDAO.getInstance().buscarTodas(Questao.class);
        questao = new Questao();
    }
    
    public void remover(){
        QuestaoDAO.getInstance().remover(Questao.class, questao.getId());
        questoes = QuestaoDAO.getInstance().buscarTodas(Questao.class);
        questao = new Questao();
    }

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }

    public List<Questao> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<Questao> questoes) {
        this.questoes = questoes;
    }    
}
