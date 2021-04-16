package com.uniacademia.enade.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.uniacademia.enade.dao.ProvaDAO;
import com.uniacademia.enade.model.Prova;

@Named
@ViewScoped
public class ProvaController {

    List<Prova> provas = new ArrayList<>();
    ProvaDAO dao = ProvaDAO.getInstance();

    public ProvaController() {
        provas = dao.buscarTodas(Prova.class);
    }

    public void gravar(Prova prova) {
        ProvaDAO.getInstance().atualizar(prova);
        provas = dao.buscarTodas(Prova.class);
    }

    public void remover(Prova prova) {
        ProvaDAO.getInstance().remover(prova);
        provas = dao.buscarTodas(Prova.class);
    }

    public List<Prova> getProvas() {
        return provas;
    }

}
