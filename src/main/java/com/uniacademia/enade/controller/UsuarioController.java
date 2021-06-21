package com.uniacademia.enade.controller;

import com.google.common.hash.Hashing;
import com.uniacademia.enade.dao.UsuarioDAO;
import com.uniacademia.enade.model.Usuario;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class UsuarioController implements Serializable{
    
    private Usuario usuario;
    private List<Usuario> usuarios;
    
    public UsuarioController(){
        usuarios = new ArrayList<>();
        usuarios = UsuarioDAO.getInstance().buscarTodas(Usuario.class);
        usuario = new Usuario();
    }
    
    public void gravar(){
        String senhaCriptografada = Hashing.sha256().hashString(usuario.getSenha(), StandardCharsets.UTF_8).toString();
        usuario.setSenha(senhaCriptografada);
        UsuarioDAO.getInstance().persistir(usuario);
        usuarios = UsuarioDAO.getInstance().buscarTodas(Usuario.class);
        usuario = new Usuario();
    }
    
    public void remover(){
        UsuarioDAO.getInstance().remover(Usuario.class, usuario.getId());
        usuarios = UsuarioDAO.getInstance().buscarTodas(Usuario.class);
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    
    
}
