package com.uniacademia.enade.controller;

import com.uniacademia.enade.dao.ProvaDAO;
import com.uniacademia.enade.model.Prova;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ProvaController implements Serializable{
    
    private Prova prova;
    private List<Prova> provas;
    
    public ProvaController(){
        provas = new ArrayList<>();
        provas = ProvaDAO.getInstance().buscarTodas(Prova.class);
        prova = new Prova();
    }
    
    public void gravar(){
        ProvaDAO.getInstance().persistir(prova);
        provas = ProvaDAO.getInstance().buscarTodas(Prova.class);
        prova = new Prova();
    }
    
    public void remover(){
        ProvaDAO.getInstance().remover(Prova.class, prova.getId());
        provas = ProvaDAO.getInstance().buscarTodas(Prova.class);
        prova = new Prova();
    }

    public Prova getProva() {
        return prova;
    }

    public void setProva(Prova prova) {
        this.prova = prova;
    }

    public List<Prova> getProvas() {
        return provas;
    }

    public void setProvas(List<Prova> provas) {
        this.provas = provas;
    }
    
    
}
