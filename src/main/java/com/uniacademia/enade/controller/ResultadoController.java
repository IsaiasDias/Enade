package com.uniacademia.enade.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.uniacademia.enade.dao.ResultadoDAO;
import com.uniacademia.enade.model.Resultado;

@Named
@ViewScoped
public class ResultadoController {

	List<Resultado> resultados = new ArrayList<>();
	ResultadoDAO dao = ResultadoDAO.getInstance();

    public ResultadoController() {
    	resultados = dao.buscarTodas(Resultado.class);
    }

    public void gravar(Resultado resultado) {
        dao.atualizar(resultado);
        resultados = dao.buscarTodas(Resultado.class);
    }

    public void remover(Resultado resultado) {
        dao.remover(resultado);
        resultados = dao.buscarTodas(Resultado.class);
    }

    public List<Resultado> getResultados() {
        return resultados;
    }

}
