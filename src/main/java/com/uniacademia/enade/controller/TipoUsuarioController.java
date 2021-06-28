package com.uniacademia.enade.controller;

import com.uniacademia.enade.dao.TipoUsuarioDAO;
import com.uniacademia.enade.model.TipoUsuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class TipoUsuarioController implements Serializable{
    
    private TipoUsuario tipoUsuario;
    private List<TipoUsuario> tipoUsuarios;
    
    public TipoUsuarioController(){
        tipoUsuarios = new ArrayList<>();
        tipoUsuarios = TipoUsuarioDAO.getInstance().buscarTodas(TipoUsuario.class);
        tipoUsuario = new TipoUsuario();
    }
    
    public void gravar(){
        TipoUsuarioDAO.getInstance().persistir(tipoUsuario);
        tipoUsuarios = TipoUsuarioDAO.getInstance().buscarTodas(TipoUsuario.class);
        tipoUsuario = new TipoUsuario();
    }
    
    public void remover(){
        TipoUsuarioDAO.getInstance().remover(TipoUsuario.class, tipoUsuario.getId());
        tipoUsuarios = TipoUsuarioDAO.getInstance().buscarTodas(TipoUsuario.class);
        tipoUsuario = new TipoUsuario();
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public List<TipoUsuario> getTipoUsuarios() {
        return tipoUsuarios;
    }

    public void setTipoUsuarios(List<TipoUsuario> tipoUsuarios) {
        this.tipoUsuarios = tipoUsuarios;
    }

    
}
    
