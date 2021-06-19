package com.uniacademia.enade.controller;

import com.uniacademia.enade.dao.TipoQuestaoDAO;
import com.uniacademia.enade.model.TipoQuestao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class TipoQuestaoController implements Serializable{
    
    private TipoQuestao tipoQuestao;
    private List<TipoQuestao> tipoQuestoes;
    
    public TipoQuestaoController(){
        tipoQuestoes = new ArrayList<>();
        tipoQuestoes = TipoQuestaoDAO.getInstance().buscarTodas(TipoQuestao.class);
        tipoQuestao = new TipoQuestao();
    }
    
    public void gravar(){
        TipoQuestaoDAO.getInstance().persistir(tipoQuestao);
        tipoQuestoes = TipoQuestaoDAO.getInstance().buscarTodas(TipoQuestao.class);
        tipoQuestao = new TipoQuestao();
    }
    
    public void remover(){
        TipoQuestaoDAO.getInstance().remover(TipoQuestao.class, tipoQuestao.getId());
        tipoQuestoes = TipoQuestaoDAO.getInstance().buscarTodas(TipoQuestao.class);
        tipoQuestao = new TipoQuestao();
    }

    public TipoQuestao getTipoQuestao() {
        return tipoQuestao;
    }

    public void setTipoQuestao(TipoQuestao tipoQuestao) {
        this.tipoQuestao = tipoQuestao;
    }

    public List<TipoQuestao> getTipoQuestoes() {
        return tipoQuestoes;
    }

    public void setTipoQuestoes(List<TipoQuestao> tipoQuestoes) {
        this.tipoQuestoes = tipoQuestoes;
    }   
}
