package com.uniacademia.enade.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.uniacademia.enade.dao.ProvaDAO;
import com.uniacademia.enade.model.Prova;
import java.io.Serializable;

@Named
@ViewScoped
public class ProvaController implements Serializable {

	private static final long serialVersionUID = 1674527709172387479L;
	private List<Prova> provas = new ArrayList<>();
    private ProvaDAO dao = ProvaDAO.getInstance();

    public ProvaController() {
        provas = dao.buscarTodas(Prova.class);
    }

    public void gravar(Prova prova) {
        ProvaDAO.getInstance().atualizar(prova);
        provas = dao.buscarTodas(Prova.class);
    }

    public void remover(Prova prova) {
        ProvaDAO.getInstance().remover(Prova.class, prova.getId());
        provas = dao.buscarTodas(Prova.class);
    }

    public List<Prova> getProvas() {
        return provas;
    }

}
