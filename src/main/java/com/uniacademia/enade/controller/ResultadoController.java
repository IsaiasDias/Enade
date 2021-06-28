package com.uniacademia.enade.controller;


import com.uniacademia.enade.dao.ResultadoDAO;
import com.uniacademia.enade.model.Resultado;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ResultadoController implements Serializable{
    
    private Resultado resultado;
    private List<Resultado> resultados;
    
    public ResultadoController(){
        resultados = new ArrayList<>();
        resultados = ResultadoDAO.getInstance().buscarTodas(Resultado.class);
        resultado = new Resultado();
    }
    
    public void gravar(){
        ResultadoDAO.getInstance().persistir(resultado);
        resultados = ResultadoDAO.getInstance().buscarTodas(Resultado.class);
        resultado = new Resultado();
    }
    
    public void remover(){
        ResultadoDAO.getInstance().remover(Resultado.class, resultado.getId());
        resultados = ResultadoDAO.getInstance().buscarTodas(Resultado.class);
        resultado = new Resultado();
    }

    public Resultado getResultado() {
        return resultado;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }

    public List<Resultado> getResultados() {
        return resultados;
    }

    public void setResultados(List<Resultado> resultados) {
        this.resultados = resultados;
    }
    
    
}
