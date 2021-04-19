package com.uniacademia.enade.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.uniacademia.enade.dao.ResultadoDAO;
import com.uniacademia.enade.model.Resultado;
import java.io.Serializable;

@Named
@ViewScoped
public class ResultadoController implements Serializable {

	private static final long serialVersionUID = 1045515314003056478L;
	private List<Resultado> resultados = new ArrayList<>();
	private ResultadoDAO dao = ResultadoDAO.getInstance();

    public ResultadoController() {
    	resultados = dao.buscarTodas(Resultado.class);
    }

    public void gravar(Resultado resultado) {
        dao.atualizar(resultado);
        resultados = dao.buscarTodas(Resultado.class);
    }

    public void remover(Resultado resultado) {
        dao.remover(Resultado.class, resultado.getId());
        resultados = dao.buscarTodas(Resultado.class);
    }

    public List<Resultado> getResultados() {
        return resultados;
    }

}
