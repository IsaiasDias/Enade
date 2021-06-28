package com.uniacademia.enade.controller;

import com.uniacademia.enade.dao.QuestaoDAO;
import com.uniacademia.enade.model.Questao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;

@Named
@ViewScoped
public class QuestaoController implements Serializable {
    
    private Questao questao;
    private List<Questao> questoes;
    List<Questao> questoesAtivas = new ArrayList<>();
    
    public QuestaoController(){
        questoes = new ArrayList<>();
        questoes = QuestaoDAO.getInstance().buscarTodas(Questao.class);
        questoesAtivas = QuestaoDAO.getInstance().findQuestoesAtivas();
        questao = new Questao();
    }
    
    public void gravar(){
        QuestaoDAO.getInstance().persistir(questao);
        questoes = QuestaoDAO.getInstance().buscarTodas(Questao.class);
        questoesAtivas = QuestaoDAO.getInstance().findQuestoesAtivas();
        questao = new Questao();
    }
    
    public void remover(){
        QuestaoDAO.getInstance().remover(Questao.class, questao.getId());
        questoes = QuestaoDAO.getInstance().buscarTodas(Questao.class);
        questoesAtivas = QuestaoDAO.getInstance().findQuestoesAtivas();
        questao = new Questao();
    }
    
    public void onRowEdit(RowEditEvent event) {
        Questao obj = (Questao) event.getObject();
        setQuestao(obj);
        gravar();
        FacesMessage msg = new FacesMessage("Editado", obj.getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent<Questao> event) {
        FacesMessage msg = new FacesMessage("Cancelado", event.getObject().getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
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

    public List<Questao> getQuestoesAtivas() {
        return questoesAtivas;
    }
}
