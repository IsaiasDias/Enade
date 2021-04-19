package com.uniacademia.enade.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.uniacademia.enade.dao.UsuarioDAO;
import com.uniacademia.enade.model.Usuario;
import java.io.Serializable;

@Named
@ViewScoped
public class UsuarioController implements Serializable {

	private static final long serialVersionUID = 6855511354615947874L;
	private List<Usuario> usuarios = new ArrayList<>();
	private UsuarioDAO dao = UsuarioDAO.getInstance();

    public UsuarioController() {
    	usuarios = dao.buscarTodas(Usuario.class);
    }

    public void gravar(Usuario usuario) {
        dao.atualizar(usuario);
        usuarios = dao.buscarTodas(Usuario.class);
    }

    public void remover(Usuario usuario) {
        dao.remover(Usuario.class, usuario.getId());
        usuarios = dao.buscarTodas(Usuario.class);
    }

    public List<Usuario> getUsuario() {
        return usuarios;
    }

}
