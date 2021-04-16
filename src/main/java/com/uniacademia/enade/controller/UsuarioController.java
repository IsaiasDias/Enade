package com.uniacademia.enade.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.uniacademia.enade.dao.UsuarioDAO;
import com.uniacademia.enade.model.Usuario;

@Named
@ViewScoped
public class UsuarioController {

	List<Usuario> usuarios = new ArrayList<>();
	UsuarioDAO dao = UsuarioDAO.getInstance();

    public UsuarioController() {
    	usuarios = dao.buscarTodas(Usuario.class);
    }

    public void gravar(Usuario usuario) {
        dao.atualizar(usuario);
        usuarios = dao.buscarTodas(Usuario.class);
    }

    public void remover(Usuario usuario) {
        dao.remover(usuario);
        usuarios = dao.buscarTodas(Usuario.class);
    }

    public List<Usuario> getUsuario() {
        return usuarios;
    }

}
