package com.uniacademia.enade.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.uniacademia.enade.dao.TipoUsuarioDAO;
import com.uniacademia.enade.model.TipoUsuario;
import java.io.Serializable;

@Named
@ViewScoped
public class TipoUsuarioController implements Serializable {

	private static final long serialVersionUID = 8422465146501425077L;
	private List<TipoUsuario> tiposUsuarios = new ArrayList<>();
	private TipoUsuarioDAO dao = TipoUsuarioDAO.getInstance();

    public TipoUsuarioController() {
    	tiposUsuarios = dao.buscarTodas(TipoUsuario.class);
    }

    public void gravar(TipoUsuario tipoUsuario) {
        dao.atualizar(tipoUsuario);
        tiposUsuarios = dao.buscarTodas(TipoUsuario.class);
    }

    public void remover(TipoUsuario tipoUsuario) {
        dao.remover(TipoUsuario.class, tipoUsuario.getId());
        tiposUsuarios = dao.buscarTodas(TipoUsuario.class);
    }

    public List<TipoUsuario> getTiposUsuarios() {
        return tiposUsuarios;
    }

}
